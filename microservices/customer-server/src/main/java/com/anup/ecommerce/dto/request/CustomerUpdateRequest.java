package com.anup.ecommerce.dto.request;

import com.anup.ecommerce.entity.Address;
import jakarta.validation.constraints.Email;
import lombok.Getter;

@Getter
public class CustomerUpdateRequest {
    private String firstName;

    private String lastName;

    @Email(message = "Invalid email format")
    private String email;

    private Address address;
}
