package com.anup.ecommerce.dto.response;

import com.anup.ecommerce.entity.Address;

public record CustomerResponse(
        String id,
        String firstName,
        String lastName,
        String email,
        Address address
) { }
