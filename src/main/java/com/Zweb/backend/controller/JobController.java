package com.Zweb.backend.controller;

import com.Zweb.backend.dto.JobDto;

import com.Zweb.backend.models.ApplicationRequest;
import com.Zweb.backend.models.ApplicationResponse;
import com.Zweb.backend.service.ApplicantService;
import com.Zweb.backend.service.JobService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/web-api/jobs")
public class JobController {
    private final JobService jobService;
    private final ApplicantService applicantService;

    public JobController(JobService jobService, ApplicantService applicantService) {
        this.jobService = jobService;
        this.applicantService = applicantService;
    }
    @GetMapping
    public ResponseEntity<Page<JobDto>> getAllJobs(
            @RequestParam(required = false) String title,
            @RequestParam(defaultValue = "0") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize
            ) {
        return ResponseEntity.ok(jobService.findAllJobs(title, pageNum, pageSize));
    }
    @GetMapping("/{id}")
    public ResponseEntity<JobDto> getJobById(@PathVariable String id) {
        return ResponseEntity.ok(jobService.findJobById(id));
    }
    @PostMapping("/{id}/apply")
    public ResponseEntity<ApplicationResponse> applyToJob(@PathVariable String id, @RequestBody @Validated ApplicationRequest request) {
        ApplicationResponse response = applicantService.apply(request, id);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
