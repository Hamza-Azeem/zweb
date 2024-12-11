package com.Zweb.backend.mapper;

import com.Zweb.backend.dto.ApplicationDto;
import com.Zweb.backend.entity.Application;

public class ApplicationMapper {
    public static ApplicationDto convertToApplicationDto(Application application) {
        return new ApplicationDto(
                application.getId(),
                application.getApplicant().getName(),
                application.getDate(),
                application.getApplicant().getEmail(),
                application.getApplicant().getPhoneNumber(),
                application.getApplicant().getDescription()
        );
    }
}
