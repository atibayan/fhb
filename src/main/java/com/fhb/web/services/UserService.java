package com.fhb.web.services;

import com.fhb.web.dtos.RegistrationDto;
import com.fhb.web.models.User;

public interface UserService {

    void save(RegistrationDto user);
    User findByEmail(String email);
    User findByUserName(String userName);
}
