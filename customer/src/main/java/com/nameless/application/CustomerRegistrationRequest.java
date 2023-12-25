package com.nameless.application;

public record CustomerRegistrationRequest(String firstName,
                                          String lastName,
                                          String email) {
}
