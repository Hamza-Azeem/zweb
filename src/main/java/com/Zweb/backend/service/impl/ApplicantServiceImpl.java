package com.Zweb.backend.service.impl;

import com.Zweb.backend.dto.JobDto;
import com.Zweb.backend.entity.Applicant;
import com.Zweb.backend.entity.Job;
import com.Zweb.backend.exception.ResourceNotFoundException;
import com.Zweb.backend.models.ApplicationRequest;
import com.Zweb.backend.models.ApplicationResponse;
import com.Zweb.backend.repository.ApplicantRepository;
import com.Zweb.backend.service.ApplicantService;
import com.Zweb.backend.service.ApplicationService;
import com.Zweb.backend.service.JobService;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.Zweb.backend.mapper.JobMapper.convertToJob;

@Service
public class ApplicantServiceImpl implements ApplicantService {
    private final ApplicantRepository repository;
    private final JobService jobService;
    private final ApplicationService applicationService;

    public ApplicantServiceImpl(ApplicantRepository repository, JobService jobService, ApplicationService applicationService) {
        this.repository = repository;
        this.jobService = jobService;
        this.applicationService = applicationService;
    }

    @Override
    public ApplicationResponse apply(ApplicationRequest request, String jobId) {
        JobDto jobDto = jobService.findJobById(jobId);
        Job job = convertToJob(jobDto);
        Optional<Applicant> applicantOptional = repository.findByEmail(request.getEmail());
        Applicant applicant = new Applicant();
        if(applicantOptional.isEmpty()){
             applicant = new Applicant(
                    request.getName(),
                    request.getEmail(),
                    request.getPhoneNumber(),
                    request.getDescription()
            );
            applicant = repository.insert(applicant);
        }else{
            applicant = applicantOptional.get();
        }
        String applicationId = applicationService.saveApplication(applicant, job);
        return new ApplicationResponse("Application submitted successfully.", applicationId);
    }

    @Override
    public Applicant findApplicantByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("Applicant not found"));
    }

}
