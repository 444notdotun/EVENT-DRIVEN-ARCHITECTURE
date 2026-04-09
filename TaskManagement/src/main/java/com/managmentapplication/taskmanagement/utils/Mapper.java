package com.managmentapplication.taskmanagement.utils;
import com.managmentapplication.taskmanagement.data.models.Project;
import com.managmentapplication.taskmanagement.data.models.Task;
import com.managmentapplication.taskmanagement.data.models.Users;
import com.managmentapplication.taskmanagement.dtos.request.CreateProjectRequest;
import com.managmentapplication.taskmanagement.dtos.request.CreateTaskRequest;
import com.managmentapplication.taskmanagement.dtos.request.RegisterUserRequest;
import com.managmentapplication.taskmanagement.dtos.response.AuthResponse;
import com.managmentapplication.taskmanagement.dtos.response.CreateProjectServiceResponse;
import com.managmentapplication.taskmanagement.dtos.response.CreateTaskResponse;
import com.managmentapplication.taskmanagement.service.ServiceInterface.JwtService;



public class Mapper {
    public static Users mapRequestToUser(RegisterUserRequest registerUserRequest) {
        Users users = new Users();
        users.setUsername(registerUserRequest.getUsername());
        users.setPassword(registerUserRequest.getPassword());
        users.setFirstNAme(registerUserRequest.getFirstName());
        users.setLastNAme(registerUserRequest.getLastName());
        users.setRole(registerUserRequest.getRole());
        return users;
    }

    public static AuthResponse mapUserToResponse(Users users,JwtService jwtService) {
        AuthResponse  authResponse = new AuthResponse();
        authResponse.setUsername(users.getUsername());
        authResponse.setFirstName(users.getFirstNAme());
        authResponse.setUserId(users.getUserId());
        authResponse.setLastName(users.getLastNAme());
        authResponse.setToken(jwtService.generateToken(users));
        authResponse.setRole(users.getRole());
        return authResponse;
    }

    public static Project mapRequestToProject(CreateProjectRequest createProjectRequest,Users users) {
        Project project = new Project();
        project.setProjectName(createProjectRequest.getProjectName());
        project.setProjectDescription(createProjectRequest.getProjectDescription());
        project.setUsers(users);
        return  project;
    }

    public static CreateProjectServiceResponse mapCreateProjectResponseToproject(Project project) {
        CreateProjectServiceResponse createProjectServiceResponse = new CreateProjectServiceResponse();
        createProjectServiceResponse.setProjectName(project.getProjectName());
        createProjectServiceResponse.setProjectDescription(project.getProjectDescription());
        createProjectServiceResponse.setUsers(project.getUsers().getUserId());
        createProjectServiceResponse.setProjectId(project.getProjectId());
        createProjectServiceResponse.setProjectStatus(project.getProjectStatus());
        createProjectServiceResponse.setProjectEndDate(project.getProjectEndDate());
        createProjectServiceResponse.setProjectStartDate(project.getProjectStartDate());
        return  createProjectServiceResponse;

    }

    public static Task mapCreateTaskWithRequest(Users users ,Project projectId, CreateTaskRequest createTaskRequest) {
        Task task = new Task();
        task.setTaskDescription(createTaskRequest.getTaskDescription());
        task.setTaskName(createTaskRequest.getTaskName());
        task.setProject(projectId);
        task.setUserId(users);
        return  task;
    }

    public static CreateTaskResponse mapTaskToCreateTaskResponse(Task task) {
        CreateTaskResponse  createTaskResponse = new CreateTaskResponse();
        createTaskResponse.setTaskStatus(task.getTaskStatus());
        createTaskResponse.setTaskDescription(task.getTaskDescription());
        createTaskResponse.setTaskName(task.getTaskName());
        createTaskResponse.setTaskId(task.getTaskId());
        createTaskResponse.setProject(task.getProject().getProjectId());
        createTaskResponse.setUserId(task.getUserId().getUserId());
        return  createTaskResponse;
    }
}
