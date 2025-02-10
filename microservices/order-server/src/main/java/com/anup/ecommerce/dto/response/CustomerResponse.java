package com.anup.ecommerce.dto.response;

import lombok.Builder;

@Builder
public class CustomerResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
}
