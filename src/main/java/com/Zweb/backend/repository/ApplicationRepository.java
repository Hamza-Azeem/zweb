package com.Zweb.backend.repository;

import com.Zweb.backend.entity.Applicant;
import com.Zweb.backend.entity.Application;
import com.Zweb.backend.entity.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ApplicationRepository extends MongoRepository<Application, String> {
     Page<Application> findAllByApplicant(Applicant applicant, Pageable pageable);
     Page<Application> findAllByJob(Job job, Pageable pageable);
     boolean existsByApplicantAndJob(Applicant applicant, Job job);

}
