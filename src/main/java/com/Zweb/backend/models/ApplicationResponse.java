package com.Zweb.backend.models;

public class ApplicationResponse {
    private String message;
    private String applicationId;

    public ApplicationResponse(String message, String applicationId) {
        this.message = message;
        this.applicationId = applicationId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }
}
