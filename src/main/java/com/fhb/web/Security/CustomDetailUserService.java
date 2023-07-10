package com.fhb.web.Security;

import com.fhb.web.models.User;
import com.fhb.web.repositories.UserRepository;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CustomDetailUserService implements UserDetailsService {
    private UserRepository userRepository;

    public CustomDetailUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findFirstByUserName(username);

        if (user != null) {
            org.springframework.security.core.userdetails.User authUser= new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                    user.getPassword(),
                    user.getRole()
                            .stream().map( (role)-> new SimpleGrantedAuthority(role.getName()))
                            .collect(Collectors.toList())
            );
            return authUser;
        }else {
            throw new UsernameNotFoundException("Invalid username or password");
        }


    }
}
