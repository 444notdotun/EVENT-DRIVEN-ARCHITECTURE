package com.managmentapplication.taskmanagement.service.impl;

import com.managmentapplication.taskmanagement.data.models.Role;
import com.managmentapplication.taskmanagement.dtos.request.CreateProjectRequest;
import com.managmentapplication.taskmanagement.dtos.request.CreateTaskRequest;
import com.managmentapplication.taskmanagement.dtos.request.RegisterUserRequest;
import com.managmentapplication.taskmanagement.dtos.response.AuthResponse;
import com.managmentapplication.taskmanagement.dtos.response.CreateProjectServiceResponse;
import com.managmentapplication.taskmanagement.dtos.response.CreateTaskResponse;
import com.managmentapplication.taskmanagement.service.ServiceInterface.ProjectService;
import com.managmentapplication.taskmanagement.service.ServiceInterface.UsersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProjectTest {
    @Autowired
    UsersService  usersService;

    @Autowired
    ProjectService  projectService;


    RegisterUserRequest  registerUserRequest;
    CreateProjectRequest createProjectRequest;
    String username;
    CreateTaskRequest createTaskRequest;
    String projectId;

    @BeforeEach
    void setUp() {
        registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUsername("admin");
        registerUserRequest.setPassword("password");
        registerUserRequest.setRole(Role.MANAGER);
        registerUserRequest.setFirstName("adewole");
        registerUserRequest.setLastName("adeniyi");
        createProjectRequest = new CreateProjectRequest();
        createProjectRequest.setProjectName("creating saas");
        createProjectRequest.setProjectDescription("creating saas that can be upscaled");
        username=registerUserRequest.getUsername();
        createTaskRequest = new CreateTaskRequest();
        createTaskRequest.setTaskDescription("creating saas that can be upscaled in task 1");
        createTaskRequest.setTaskName("task 1");
    }
    @Test
    void testThatUserCanCreateProject(){
        AuthResponse authResponse = usersService.RegisterUser(registerUserRequest);
        assertEquals(authResponse.getUsername(),registerUserRequest.getUsername());
        CreateProjectServiceResponse createProjectServiceResponse = projectService.createProject(createProjectRequest, username);
        assertEquals(createProjectServiceResponse.getProjectName(),createProjectRequest.getProjectName());
        assertEquals(createProjectServiceResponse.getUsers(),authResponse.getUserId());
        projectId=createProjectServiceResponse.getProjectId();


    }

    @Test
    void testThatUserCreateTask(){
        registerUserRequest.setUsername("niyi");
        AuthResponse authResponse = usersService.RegisterUser(registerUserRequest);
        assertEquals(authResponse.getUsername(),registerUserRequest.getUsername());
        username=registerUserRequest.getUsername();
        CreateProjectServiceResponse createProjectServiceResponse = projectService.createProject(createProjectRequest, username);
        assertEquals(createProjectServiceResponse.getProjectName(),createProjectRequest.getProjectName());
        assertEquals(createProjectServiceResponse.getUsers(),authResponse.getUserId());
        projectId=createProjectServiceResponse.getProjectId();
        CreateTaskResponse createTaskResponse = projectService.createTask(createTaskRequest,projectId,username);
        assertNotNull(createTaskResponse);
        assertEquals(createTaskResponse.getTaskName(), createTaskRequest.getTaskName());
    }



}