package com.managmentapplication.taskmanagement.service.impl;

import com.managmentapplication.taskmanagement.data.models.Users;
import com.managmentapplication.taskmanagement.data.repository.UserRepository;
import com.managmentapplication.taskmanagement.dtos.request.LoginRequest;
import com.managmentapplication.taskmanagement.dtos.request.RegisterUserRequest;
import com.managmentapplication.taskmanagement.dtos.response.AuthResponse;
import com.managmentapplication.taskmanagement.exception.UsersAlreadyExist;
import com.managmentapplication.taskmanagement.exception.WrongPassWordException;
import com.managmentapplication.taskmanagement.service.ServiceInterface.JwtService;
import com.managmentapplication.taskmanagement.service.ServiceInterface.UsersService;
import com.managmentapplication.taskmanagement.utils.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UsersService, UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtService jwtService;
    @Autowired
    PasswordEncoder passwordEncoder;



    @Override
    public AuthResponse RegisterUser(RegisterUserRequest registerUserRequest) {
        validateUser(registerUserRequest.getUsername());
        registerUserRequest.setPassword(passwordEncoder.encode(registerUserRequest.getPassword()));
        Users users =Mapper.mapRequestToUser(registerUserRequest);
        userRepository.save(users);
        return Mapper.mapUserToResponse(users,jwtService);
    }

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        Users user = (Users)loadUserByUsername(loginRequest.getUsername());
        if(passwordEncoder.matches(loginRequest.getPassword(),user.getPassword())){
            return  Mapper.mapUserToResponse(user,jwtService);
        }
        throw  new WrongPassWordException("wrong password");
    }

    private void validateUser(String registerUserRequest) {
        if(userRepository.existsByUsername(registerUserRequest)) {
            log.info("Username already exists");
            throw new UsersAlreadyExist("username already exist");
        }
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).
                orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    }
}
