package org.nameless.application;

import jakarta.validation.constraints.NotBlank;

public record CustomerRegistrationRequest(
        @NotBlank(message = "firstName must be set") String firstName,
        @NotBlank(message = "lastName must be set") String lastName,
        @NotBlank(message = "email must be set") String email
) { }
