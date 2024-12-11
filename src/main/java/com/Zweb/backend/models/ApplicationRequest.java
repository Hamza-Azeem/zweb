package com.Zweb.backend.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public class ApplicationRequest {
    @NotBlank(message = "Name can't be empty")
    private String name;
    @NotBlank(message = "Email can't be empty")
    @Email(message = "Email format is incorrect")
    private String email;
    @NotBlank(message = "Phone Number can't be empty")
    @Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$", message = "Invalid phone number")
    private String phoneNumber;
    @NotBlank(message = "Description can't be empty")
    private String description;

    public ApplicationRequest(String name, String email, String phoneNumber, String description) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
