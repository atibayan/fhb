package com.fhb.web.services.impl;

import com.fhb.web.dtos.RegistrationDto;
import com.fhb.web.mapper.UserMapper;
import com.fhb.web.models.User;
import com.fhb.web.repositories.UserRepository;
import com.fhb.web.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(RegistrationDto userDto) {
        User user = UserMapper.mapToUser(userDto);

        LOGGER.info(userDto.toString()+ " " + user.toString());
        User savedUser = userRepository.save(user);

        LOGGER.info(savedUser != null ? "SAVED SUCCESS" : "SAVED FAILED");
    }

    @Override
    public User findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.isPresent() ? user.get() : null ;
    }

    @Override
    public User findByUserName(String userName) {
        Optional<User> user = userRepository.findByUserName(userName);
        return user.isPresent() ? user.get() : null ;
    }


}
