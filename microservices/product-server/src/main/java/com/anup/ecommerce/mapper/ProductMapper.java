package com.anup.ecommerce.mapper;

import com.anup.ecommerce.dto.request.ProductCreateRequest;
import com.anup.ecommerce.dto.response.CategoryResponse;
import com.anup.ecommerce.dto.response.ProductResponse;
import com.anup.ecommerce.entity.Category;
import com.anup.ecommerce.entity.Product;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class ProductMapper {
    public static Product toEntity(ProductCreateRequest request) {
        return Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .availableQuantity(request.getAvailableQuantity())
                .price(request.getPrice())
                .category(
                        Category.builder()
                                .id(request.getCategoryId())
                                .build())
                .build();
    }

    public static Product toEntity(Product existingProduct, ProductCreateRequest request) {
        if (request.getName() != null) {
            existingProduct.setName(request.getName());
        }
        if (request.getDescription() != null) {
            existingProduct.setDescription(request.getDescription());
        }
        if (request.getAvailableQuantity() > 0) {
            existingProduct.setAvailableQuantity(request.getAvailableQuantity());
        }
        if (request.getPrice().intValue() > 0) {
            existingProduct.setPrice(request.getPrice());
        }
        if (request.getCategoryId() > 0) {
            existingProduct.setCategory(
                    Category.builder()
                            .id(request.getCategoryId())
                            .build());
        }

        return existingProduct;
    }

    public static ProductResponse toResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .availableQuantity(product.getAvailableQuantity())
                .price(product.getPrice())
                .category(CategoryResponse.builder()
                        .id(product.getCategory().getId())
                        .name(product.getCategory().getName())
                        .description(product.getCategory().getDescription())
                        .build())
                .build();
    }

    public static List<ProductResponse> toResponseList(List<Product> products) {
        return products.stream()
                .map(ProductMapper::toResponse)
                .toList();
    }
}
