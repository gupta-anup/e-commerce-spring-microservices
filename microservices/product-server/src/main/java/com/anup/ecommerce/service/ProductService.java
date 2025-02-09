package com.anup.ecommerce.service;

import com.anup.ecommerce.dto.request.ProductCreateRequest;
import com.anup.ecommerce.dto.request.ProductPurchaseRequest;
import com.anup.ecommerce.dto.response.ProductResponse;
import com.anup.ecommerce.entity.Product;
import com.anup.ecommerce.exception.CustomException;
import com.anup.ecommerce.mapper.ProductMapper;
import com.anup.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductCreateRequest request) {
        Product product = ProductMapper.toEntity(request);

        Product savedProduct = productRepository.save(product);

        return ProductMapper.toResponse(savedProduct);
    }

    public List<ProductResponse> purchaseProducts(List<ProductPurchaseRequest> request) {
        List<Long> productIds = request.stream()
                .map(ProductPurchaseRequest::getId)
                .toList();

        List<Product> storedProducts = productRepository.findAllById(productIds);
        if(productIds.size() != storedProducts.size()) {
            throw new CustomException("One or more products does not exist", HttpStatus.BAD_REQUEST);
        }

        List<ProductPurchaseRequest> sortedRequest = request.stream()
                .sorted((a, b) -> a.getId().compareTo(b.getId()))
                .toList();

        List<ProductResponse> purchasedProducts = new ArrayList<ProductResponse>();
        for(int i = 0; i < storedProducts.size(); i++) {
            Product product = getProduct(storedProducts, i, sortedRequest);
            Product updatedProduct = productRepository.save(product);

            purchasedProducts.add(ProductMapper.toResponse(updatedProduct));
        }
        return purchasedProducts;
    }

    private static Product getProduct(List<Product> storedProducts, int i, List<ProductPurchaseRequest> sortedRequest) {
        Product product = storedProducts.get(i);
        ProductPurchaseRequest productRequest = sortedRequest.get(i);

        if(product.getAvailableQuantity() < productRequest.getAvailableQuantity()) {
            throw new CustomException(
                    String.format("Not enough quantity for product with id: %s", product.getId()),
                    HttpStatus.BAD_REQUEST
            );
        }

        double newAvailableQuantity = product.getAvailableQuantity() - productRequest.getAvailableQuantity();
        product.setAvailableQuantity(newAvailableQuantity);
        return product;
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return ProductMapper.toResponseList(products);
    }

    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new CustomException(
                        String.format("Product not found with id: %s", id),
                        HttpStatus.NOT_FOUND
                ));

        return ProductMapper.toResponse(product);
    }

    public ProductResponse updateProduct(Long id, ProductCreateRequest request) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new CustomException(
                        String.format("Product not found with id: %s", id),
                        HttpStatus.NOT_FOUND
                ));

        Product product = ProductMapper.toEntity(existingProduct, request);

        Product updatedProduct = productRepository.save(product);

        return ProductMapper.toResponse(updatedProduct);
    }
}
