package com.Zweb.backend.models;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class RegistrationRequest {
    @NotBlank(message = "Firstname can't be empty.")
    private String firstName;
    @NotBlank(message = "Lastname can't be empty.")
    private String lastName;
    @NotBlank(message = "Email can't be empty.")
    @Email(message = "Email format is incorrect.")
    private String email;
    @NotBlank(message = "Password can't be empty.")
    private String password;
    @NotBlank(message = "Phone number can't be empty.")
    @Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$", message = "Invalid phone number")
    private String phoneNumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
