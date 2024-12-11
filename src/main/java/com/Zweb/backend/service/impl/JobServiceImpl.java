package com.Zweb.backend.service.impl;

import com.Zweb.backend.dto.JobDto;
import com.Zweb.backend.entity.Job;
import com.Zweb.backend.exception.ResourceNotFoundException;
import com.Zweb.backend.mapper.JobMapper;
import com.Zweb.backend.models.JobCreationResponse;
import com.Zweb.backend.repository.JobRepository;
import com.Zweb.backend.service.JobService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import static com.Zweb.backend.mapper.JobMapper.*;

@Service
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public JobDto findJobById(String id) {
        Job job = jobRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(String.format("No job with id %s found", id)));
//        list.sort(Comparator.comparingLong(Requirements::getNo));
        return convertToCompleteJobDto(job);
    }

    @Override
    public Job findActualJob(String id) {
        return jobRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("No job with id %s found", id)));
    }

    public Page<JobDto> findAllJobs(String title, int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        if(title == null || title.isBlank()) {
            return jobRepository.findAll(pageable).map(JobMapper::convertToCompleteJobDto);
        }
        return jobRepository.findJobByTitleContainingIgnoreCase(title, pageable).map(JobMapper::convertToCompleteJobDto);
    }
    @Override
    public JobCreationResponse createJob(JobDto jobDto) {
        for(int i=0;i<jobDto.getRequirements().size();i++){
            jobDto.getRequirements().get(i).setNo(i+1);
        }
        Job createdJob = jobRepository.save(convertToJob(jobDto));
        return new JobCreationResponse("Job created successfully", createdJob.getId());
    }

    @Override
    public void deleteJob(String id) {
        jobRepository.deleteById(id);
    }

    @Override
    public String updateJob(JobDto jobDto, String id) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("No job with id %s was found.", id)));
        if (jobDto.getTitle() != null && !jobDto.getTitle().equals(job.getTitle())) {
            job.setTitle(jobDto.getTitle());
        }
        if (jobDto.getDescription() != null && !jobDto.getDescription().equals(job.getDescription())) {
            job.setDescription(jobDto.getDescription());
        }
        if (jobDto.getRequirements() != null && !jobDto.getRequirements().equals(job.getRequirements())) {
            job.getRequirements().clear();
            job.updateRequirements(jobDto.getRequirements());
        }
        if (jobDto.getOpenDate() != null && !jobDto.getOpenDate().equals(job.getOpenDate())) {
            job.setOpenDate(jobDto.getOpenDate());
        }
        if (jobDto.getDeadline() != null && !jobDto.getDeadline().equals(job.getDeadLine())) {
            job.setDeadLine(jobDto.getDeadline());
        }
        if (jobDto.getSalary() != null && !jobDto.getSalary().equals(job.getSalary())) {
            job.setSalary(jobDto.getSalary());
        }
        if (jobDto.getCommission() != null && !jobDto.getCommission().equals(job.getCommission())) {
            job.setCommission(jobDto.getCommission());
        }
        if (jobDto.getWorkTimeFrom() != null && !jobDto.getWorkTimeFrom().equals(job.getWorkTimeFrom())) {
            job.setWorkTimeFrom(jobDto.getWorkTimeFrom());
        }
        if (jobDto.getWorkTimeTo() != null && !jobDto.getWorkTimeTo().equals(job.getWorkTimeTo())) {
            job.setWorkTimeTo(jobDto.getWorkTimeTo());
        }
        if (jobDto.getWorkDayFrom() != null && !jobDto.getWorkDayFrom().equals(job.getWorkDayFrom())) {
            job.setWorkDayFrom(jobDto.getWorkDayFrom());
        }
        if (jobDto.getWorkDayTo() != null && !jobDto.getWorkDayTo().equals(job.getWorkDayTo())) {
            job.setWorkDayTo(jobDto.getWorkDayTo());
        }
        if (jobDto.getLocation() != null && !jobDto.getLocation().equals(job.getLocation())) {
            job.setLocation(jobDto.getLocation());
        }
        jobRepository.save(job);
        return "Job updated successfully";
    }
}
