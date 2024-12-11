package com.Zweb.backend.service.impl;

import com.Zweb.backend.dto.ApplicationDto;
import com.Zweb.backend.dto.UserDto;
import com.Zweb.backend.entity.Applicant;
import com.Zweb.backend.entity.Job;
import com.Zweb.backend.entity.User;
import com.Zweb.backend.exception.DuplicateResourceException;
import com.Zweb.backend.exception.ResourceNotFoundException;
import com.Zweb.backend.mapper.UserMapper;
import com.Zweb.backend.models.UserUpdateRequest;
import com.Zweb.backend.repository.UserRepository;
import com.Zweb.backend.service.ApplicantService;
import com.Zweb.backend.service.ApplicationService;
import com.Zweb.backend.service.JobService;
import com.Zweb.backend.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.Zweb.backend.mapper.UserMapper.convertToUserDto;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ApplicantService applicantService;
    private final JobService jobService;
    private final ApplicationService applicationService;
    public UserServiceImpl(UserRepository userRepository, ApplicantService applicantService, JobService jobService, ApplicationService applicationService) {
        this.userRepository = userRepository;
        this.applicantService = applicantService;
        this.jobService = jobService;
        this.applicationService = applicationService;
    }

    @Override
    public Page<UserDto> findAllUsers(String txt, int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        if(txt == null || txt.isBlank()){
            return userRepository.findAll(pageable).map(UserMapper::convertToUserDto);
        }
        if(txt.contains(".") && txt.contains("@")){
            return userRepository.findAll(pageable).map(UserMapper::convertToUserDto);
        }
        // DOESNT WORK ----
        return userRepository.findAllById(txt, pageable).map(UserMapper::convertToUserDto);
    }

    @Override
    public UserDto findUserById(String id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isEmpty()){
            throw new ResourceNotFoundException(String.format("User with id '%s' not found", id));
        }
        return convertToUserDto(userOptional.get());
    }

    @Override
    public UserDto updateUser(UserUpdateRequest updateRequest, String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(String.format("User with id '%s' not found", userId)));
        if(updateRequest.getEmail() != null && !updateRequest.getEmail().isBlank()){
            if(userRepository.existsByEmail(updateRequest.getEmail())){
                throw new DuplicateResourceException(String.format("Email: %s is linked to another account", updateRequest.getEmail()));
            }
            user.setEmail(updateRequest.getEmail());
        }
        if(updateRequest.getFirstName() != null && !updateRequest.getFirstName().isBlank()){
            user.setFirstName(updateRequest.getFirstName());
        }
        if(updateRequest.getLastName() != null && !updateRequest.getLastName().isBlank()){
            user.setLastName(updateRequest.getLastName());
        }
        if(updateRequest.getPhoneNumber() != null && !updateRequest.getPhoneNumber().isBlank()){
            user.setPhone(updateRequest.getPhoneNumber());
        }
        User updatedUser = userRepository.save(user);
        return convertToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(String userId) {
        if(!userRepository.existsById(userId)){
            throw new ResourceNotFoundException(String.format("User with id '%s' not found", userId));
        }
        userRepository.deleteById(userId);
    }

    @Override
    public Page<ApplicationDto> findAllApplications(String txt, int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        if(txt == null || txt.isBlank()){
            return applicationService.findAllApplications(pageable);
        }
        if(txt.contains("@") && txt.contains(".")){
            Applicant applicant = applicantService.findApplicantByEmail(txt);
            return applicationService.findAllApplicationsByApplicant(applicant, pageable);
        }
        Job job = jobService.findActualJob(txt);
        return applicationService.findAllApplicationsToJob(job, pageable);
    }
}
