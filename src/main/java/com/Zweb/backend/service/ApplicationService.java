package com.Zweb.backend.service;

import com.Zweb.backend.dto.ApplicationDto;
import com.Zweb.backend.entity.Applicant;
import com.Zweb.backend.entity.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ApplicationService {
    String saveApplication(Applicant applicant, Job job);
    Page<ApplicationDto> findAllApplicationsByApplicant(Applicant applicant, Pageable pageable);
    Page<ApplicationDto> findAllApplicationsToJob(Job job, Pageable pageable);
    Page<ApplicationDto> findAllApplications(Pageable pageable);
}
