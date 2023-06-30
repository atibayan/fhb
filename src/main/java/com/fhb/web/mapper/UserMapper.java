package com.fhb.web.mapper;

import com.fhb.web.dtos.RegistrationDto;
import com.fhb.web.dtos.UserDto;
import com.fhb.web.models.User;

public class UserMapper {

    public static UserDto mapToUserDto(User user) {
        UserDto userDto = UserDto.builder()
                .userName(user.getUserName())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .dob(user.getDob())
                .build();
        return userDto;
    }

    public static User mapToUser(UserDto userDto) {
        User user = User.builder()
                .userName(userDto.getUserName())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .dob(userDto.getDob())
                .build();

        return user;
    }

    public static User mapToUser(RegistrationDto registrationDto) {
        User user = User.builder()
                .userName(registrationDto.getUserName())
                .firstName(registrationDto.getFirstName())
                .lastName(registrationDto.getLastName())
                .email(registrationDto.getEmail())
                .dob(registrationDto.getDob())
                .password(registrationDto.getPassword())
                .build();

        return user;
    }
}
