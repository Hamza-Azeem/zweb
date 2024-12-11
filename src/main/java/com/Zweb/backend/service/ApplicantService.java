package com.Zweb.backend.service;

import com.Zweb.backend.entity.Applicant;
import com.Zweb.backend.models.ApplicationRequest;
import com.Zweb.backend.models.ApplicationResponse;

import java.util.Optional;


public interface ApplicantService {
    public ApplicationResponse apply(ApplicationRequest request, String id);
    public Applicant findApplicantByEmail(String email);
}
