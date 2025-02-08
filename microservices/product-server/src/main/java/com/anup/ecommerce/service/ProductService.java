package com.anup.ecommerce.service;

import com.anup.ecommerce.dto.request.ProductCreateRequest;
import com.anup.ecommerce.dto.response.ProductResponse;
import com.anup.ecommerce.entity.Product;
import com.anup.ecommerce.exception.CustomException;
import com.anup.ecommerce.mapper.ProductMapper;
import com.anup.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

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
