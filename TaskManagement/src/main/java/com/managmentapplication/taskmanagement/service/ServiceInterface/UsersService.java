package com.managmentapplication.taskmanagement.service.ServiceInterface;

import com.managmentapplication.taskmanagement.dtos.request.LoginRequest;
import com.managmentapplication.taskmanagement.dtos.request.RegisterUserRequest;
import com.managmentapplication.taskmanagement.dtos.response.AuthResponse;

public interface UsersService {

    AuthResponse RegisterUser(RegisterUserRequest registerUserRequest);
    AuthResponse login(LoginRequest loginRequest);
}
