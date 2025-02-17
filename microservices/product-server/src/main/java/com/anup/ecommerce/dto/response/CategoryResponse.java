package com.anup.ecommerce.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CategoryResponse {
    private Integer id;
    private String name;
    private String description;
}
