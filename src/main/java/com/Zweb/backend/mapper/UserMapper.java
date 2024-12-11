package com.Zweb.backend.mapper;


import com.Zweb.backend.dto.UserDto;
import com.Zweb.backend.entity.User;

public class UserMapper {
    public static UserDto convertToUserDto(User user) {
        return new UserDto(
          user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhone(),
                user.getCreatedAt(),
                user.getLastlogin(),
                user.getImg()
        );

    }
}
