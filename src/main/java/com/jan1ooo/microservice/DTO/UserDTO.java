package com.jan1ooo.microservice.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record UserDTO(Long id_user,
                      @NotEmpty(message = "Name is required") String name,
                      @Email(message = "Email is invalid") @NotEmpty(message = "Email is required") String email) {
}
