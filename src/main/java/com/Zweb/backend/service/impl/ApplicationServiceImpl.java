package com.Zweb.backend.service.impl;

import com.Zweb.backend.dto.ApplicationDto;
import com.Zweb.backend.entity.Applicant;
import com.Zweb.backend.entity.Application;
import com.Zweb.backend.entity.Job;
import com.Zweb.backend.exception.DuplicateResourceException;
import com.Zweb.backend.mapper.ApplicationMapper;
import com.Zweb.backend.repository.ApplicationRepository;
import com.Zweb.backend.service.ApplicationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    private final ApplicationRepository applicationRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public String saveApplication(Applicant applicant, Job job) {
        if(hasApplicantAppliedBefore(applicant, job)) {
            throw new DuplicateResourceException("You applied for this job before.");
        }
        Application application = new Application(
                job,
                applicant,
                LocalDate.now()
        );
        application = applicationRepository.save(application);
        return application.getId();
    }

    @Override
    public Page<ApplicationDto> findAllApplicationsByApplicant(Applicant applicant, Pageable pageable) {
        return applicationRepository.findAllByApplicant(applicant, pageable)
                .map(ApplicationMapper::convertToApplicationDto);
    }

    @Override
    public Page<ApplicationDto> findAllApplicationsToJob(Job job, Pageable pageable) {
        return applicationRepository.findAllByJob(job, pageable).map(ApplicationMapper::convertToApplicationDto);
    }

    @Override
    public Page<ApplicationDto> findAllApplications(Pageable pageable) {
        return applicationRepository.findAll(pageable).map(ApplicationMapper::convertToApplicationDto);
    }
    private boolean hasApplicantAppliedBefore(Applicant applicant, Job job){
        return applicationRepository.existsByApplicantAndJob(applicant, job);
    }
}
