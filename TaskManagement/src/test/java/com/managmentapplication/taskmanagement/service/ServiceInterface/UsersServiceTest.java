package com.managmentapplication.taskmanagement.service.ServiceInterface;

import com.managmentapplication.taskmanagement.data.models.Role;
import com.managmentapplication.taskmanagement.dtos.request.LoginRequest;
import com.managmentapplication.taskmanagement.dtos.request.RegisterUserRequest;
import com.managmentapplication.taskmanagement.dtos.response.AuthResponse;
import com.managmentapplication.taskmanagement.exception.UsersAlreadyExist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UsersServiceTest {
    @Autowired
    private UsersService usersService;

    RegisterUserRequest registerUserRequest;
    LoginRequest loginRequest;

    @BeforeEach
    void setUp() {
        registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setPassword("password");
        registerUserRequest.setUsername("username");
        registerUserRequest.setFirstName("martins");
        registerUserRequest.setLastName("daniel");
        registerUserRequest.setUsername("danielBoy");
        registerUserRequest.setRole(Role.WORKER);
        loginRequest = new LoginRequest();
        loginRequest.setPassword("password");
        loginRequest.setUsername("notdotun");
    }


    @Test
    void testThatUserCanBeCreated(){
        AuthResponse authResponse = usersService.RegisterUser(registerUserRequest);
        assertNotNull(authResponse);
        assertEquals(authResponse.getUsername(),registerUserRequest.getUsername());
        assertEquals(authResponse.getRole(),registerUserRequest.getRole());
    }

    @Test
    void testThatUserCanNotRegisterWithTheSameUsername(){
        registerUserRequest.setUsername("newdaniel");
        testThatUserCanBeCreated();
        assertThrows(UsersAlreadyExist.class,()->usersService.RegisterUser(registerUserRequest));
    }

    @Test
    void testThatUserCanRegisterAsManager(){
        registerUserRequest.setUsername("manager");
        registerUserRequest.setRole(Role.MANAGER);
        AuthResponse authResponse = usersService.RegisterUser(registerUserRequest);
        assertNotNull(authResponse);
        assertEquals(authResponse.getRole(),registerUserRequest.getRole());
    }

    @Test
    void testThatUserCanLogin(){
        registerUserRequest.setUsername("notdotun");
        AuthResponse authResponse = usersService.RegisterUser(registerUserRequest);
        assertNotNull(authResponse);
        assertEquals(authResponse.getUsername(),registerUserRequest.getUsername());
        assertEquals(authResponse.getRole(),registerUserRequest.getRole());
        AuthResponse loginresponse = usersService.login(loginRequest);
        assertNotNull(loginresponse);
        assertEquals(loginresponse.getUsername(),loginRequest.getUsername());
    }
}