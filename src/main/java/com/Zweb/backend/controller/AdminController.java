package com.Zweb.backend.controller;

import com.Zweb.backend.dto.ApplicationDto;
import com.Zweb.backend.dto.JobDto;
import com.Zweb.backend.dto.UserDto;


import com.Zweb.backend.marker.OnCreate;
import com.Zweb.backend.marker.OnUpdate;
import com.Zweb.backend.models.JobCreationResponse;
import com.Zweb.backend.models.UserUpdateRequest;
import com.Zweb.backend.service.JobService;
import com.Zweb.backend.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin-api")

public class AdminController {
    private final UserService userService;
    private final JobService jobService;

    public AdminController(UserService userService, JobService jobService) { // @AllArgsConstructor
        this.userService = userService;
        this.jobService = jobService;
    }

    @GetMapping("/admins")
    public ResponseEntity<Page<UserDto>> findAdmins(
            @RequestParam(required = false) String txt,
            @RequestParam(defaultValue = "0") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.ok(userService.findAllUsers(txt, pageNum, pageSize));
    }
    @GetMapping("/admins/{id}")
    public ResponseEntity<UserDto> findAdminById(@PathVariable String  id) {
        return ResponseEntity.ok(userService.findUserById(id));
    }
    @PutMapping("/admins/{id}")
    public ResponseEntity<UserDto> updateAdmin(@PathVariable String id, @RequestBody @Validated UserUpdateRequest updateRequest) {
        return new ResponseEntity<>(userService.updateUser(updateRequest, id), HttpStatus.CREATED);

//        return ResponseEntity.status(201).body(userService.updateUser(updateRequest, id));
    }
    @DeleteMapping("/admins/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/admins/jobs")
    public ResponseEntity<Page<JobDto>> findAllJobs(
            @RequestParam(required = false) String title,
            @RequestParam(defaultValue = "0") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.ok(jobService.findAllJobs(title, pageNum, pageSize));
    }
    @GetMapping("/admins/jobs/{id}")
    public ResponseEntity<JobDto> findJobById(@PathVariable String id) { // never return entity
        return ResponseEntity.ok(jobService.findJobById(id));
    }
    @PostMapping("/jobs")
    public ResponseEntity<JobCreationResponse> addJob(@RequestBody @Validated(OnCreate.class) JobDto jobDto){
        return new ResponseEntity<>(jobService.createJob(jobDto), HttpStatus.CREATED);
    }
    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> updateJob(@PathVariable String id, @RequestBody @Validated(OnUpdate.class) JobDto jobDto) {
        return new ResponseEntity<>(jobService.updateJob(jobDto, id), HttpStatus.CREATED);
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable String id) {
        jobService.deleteJob(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/jobs/{id}/apps")
    public ResponseEntity<Page<ApplicationDto>> getAllApplications(
//            @PathVariable String id,
            @RequestParam(required = false) String txt,
            @RequestParam(defaultValue = "0") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize
    ){
        return ResponseEntity.ok(userService.findAllApplications(txt, pageNum, pageSize));
    }

}
