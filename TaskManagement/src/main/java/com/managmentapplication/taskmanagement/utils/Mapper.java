package com.managmentapplication.taskmanagement.utils;
import com.managmentapplication.taskmanagement.data.models.Notification;
import com.managmentapplication.taskmanagement.data.models.Project;
import com.managmentapplication.taskmanagement.data.models.Task;
import com.managmentapplication.taskmanagement.data.models.Users;
import com.managmentapplication.taskmanagement.dtos.request.CreateProjectRequest;
import com.managmentapplication.taskmanagement.dtos.request.CreateTaskRequest;
import com.managmentapplication.taskmanagement.dtos.request.RegisterUserRequest;
import com.managmentapplication.taskmanagement.dtos.response.*;
import com.managmentapplication.taskmanagement.events.eventModels.TaskAssignedEvent;
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

    public static Task mapCreateTaskWithRequest(Project projectId, CreateTaskRequest createTaskRequest) {
        Task task = new Task();
        task.setTaskDescription(createTaskRequest.getTaskDescription());
        task.setTaskName(createTaskRequest.getTaskName());
        task.setProject(projectId);
        return  task;
    }

    public static CreateTaskResponse mapTaskToCreateTaskResponse(Task task) {
        CreateTaskResponse  createTaskResponse = new CreateTaskResponse();
        createTaskResponse.setTaskStatus(task.getTaskStatus());
        createTaskResponse.setTaskDescription(task.getTaskDescription());
        createTaskResponse.setTaskName(task.getTaskName());
        createTaskResponse.setTaskId(task.getTaskId());
        createTaskResponse.setProject(task.getProject().getProjectId());
        return  createTaskResponse;
    }

    public static TaskAssignedEvent mapTaskToEvent(Task task, Users users, Project project) {
        TaskAssignedEvent taskAssignedEvent = new TaskAssignedEvent();
        taskAssignedEvent.setTaskDescription(task.getTaskDescription());
        taskAssignedEvent.setTaskName(task.getTaskName());
        taskAssignedEvent.setTaskStatus(task.getTaskStatus());
        taskAssignedEvent.setUserId(users.getUsername());
        taskAssignedEvent.setProjectName(project.getProjectName());
        return  taskAssignedEvent;
    }

    public static AssignTaskResponse mapTaskToAssignTAskResponse(Task task) {
        AssignTaskResponse  assignTaskResponse = new AssignTaskResponse();
        assignTaskResponse.setTaskId(task.getTaskId());
        assignTaskResponse.setTaskStatus(task.getTaskStatus());
        assignTaskResponse.setTaskDescription(task.getTaskDescription());
        assignTaskResponse.setTaskName(task.getTaskName());
        assignTaskResponse.setProject(task.getProject());
        assignTaskResponse.setUserId(task.getUserId());
        return  assignTaskResponse;

    }

    public static Notification mapNotification(TaskAssignedEvent taskAssignedEvent) {
        Notification notification  = new Notification();
        notification.setProjectName(taskAssignedEvent.getProjectName());
        notification.setTaskStatus(taskAssignedEvent.getTaskStatus());
        notification.setTaskDescription(taskAssignedEvent.getTaskDescription());
        notification.setUserId(taskAssignedEvent.getUserId());
        notification.setProjectName(taskAssignedEvent.getProjectName());
        notification.setTaskName(taskAssignedEvent.getTaskName());
        return notification;
    }

    public static NotificationResponse mapNotificationToNotificationResponse(Notification notification) {
        NotificationResponse  notificationResponse = new NotificationResponse();
        notificationResponse.setProjectName(notification.getProjectName());
        notificationResponse.setTaskStatus(notification.getTaskStatus());
        notificationResponse.setTaskDescription(notification.getTaskDescription());
        notificationResponse.setUserId(notification.getUserId());
        notificationResponse.setTaskName(notification.getTaskName());
        return notificationResponse;
    }
}
