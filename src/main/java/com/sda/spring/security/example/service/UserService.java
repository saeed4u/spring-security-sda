package com.sda.spring.security.example.service;

import com.sda.spring.security.example.entities.User;
import com.sda.spring.security.example.web.dto.CreateUserDTO;
import com.sda.spring.security.example.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User findByLogin(String login);

    User save(UserRegistrationDto registration);

    List<User> getAllUsers();

    User createUser(CreateUserDTO createUserDTO) throws Exception;
}
