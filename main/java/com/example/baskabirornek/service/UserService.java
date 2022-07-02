package com.example.baskabirornek.service;

import com.example.baskabirornek.entity.User;
import com.example.baskabirornek.controller.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
