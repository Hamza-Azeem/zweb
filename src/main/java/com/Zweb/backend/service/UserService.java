package com.Zweb.backend.service;

import com.Zweb.backend.dto.ApplicationDto;
import com.Zweb.backend.dto.UserDto;
import com.Zweb.backend.models.UserUpdateRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
     Page<UserDto> findAllUsers(String txt, int pageNum, int pageSize);
     UserDto findUserById(String  id);
     UserDto updateUser(UserUpdateRequest updateRequest, String userId);
     void deleteUser(String userId);
     Page<ApplicationDto> findAllApplications(String txt, int pageNum, int pageSize);
}
