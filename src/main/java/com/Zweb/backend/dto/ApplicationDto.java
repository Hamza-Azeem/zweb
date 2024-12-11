package com.Zweb.backend.dto;

import java.time.LocalDate;

public class ApplicationDto {
    private String applicationId;
    private String name;
    private LocalDate date;
    private String email;
    private String phoneNumber;
    private String description;

    public ApplicationDto(String applicationId, String name, LocalDate date, String email, String phoneNumber, String description) {
        this.applicationId = applicationId;
        this.name = name;
        this.date = date;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.description = description;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
