package com.fhb.web.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UserDto {
    private Long userId;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private Date dob;
}
