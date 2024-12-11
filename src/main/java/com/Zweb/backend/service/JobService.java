package com.Zweb.backend.service;

import com.Zweb.backend.dto.JobDto;
import com.Zweb.backend.entity.Job;
import com.Zweb.backend.models.JobCreationResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface JobService {
    JobDto findJobById(String id);
    Job findActualJob(String id);
    Page<JobDto> findAllJobs(String title, int pageNum, int pageSize);
    JobCreationResponse createJob(JobDto jobDto);
    void deleteJob(String id);
    String updateJob(JobDto jobDto, String id);
}
