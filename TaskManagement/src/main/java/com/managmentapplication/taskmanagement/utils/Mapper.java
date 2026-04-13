package com.managmentapplication.taskmanagement.utils;
import com.managmentapplication.taskmanagement.data.models.*;
import com.managmentapplication.taskmanagement.dtos.request.CreateProjectRequest;
import com.managmentapplication.taskmanagement.dtos.request.CreateTaskRequest;
import com.managmentapplication.taskmanagement.dtos.request.RegisterUserRequest;
import com.managmentapplication.taskmanagement.dtos.response.*;
import com.managmentapplication.taskmanagement.events.eventModels.RegisterUserEvent;
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
        taskAssignedEvent.setUserName(users.getUsername());
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
        notification.setBody(
                "Hi " + taskAssignedEvent.getUserName() + ",\n\n" +
                        "I hope you’re doing well.\n" +
                        "You have been assigned a new task: " + taskAssignedEvent.getTaskDescription() +
                        ". Please review the requirements and begin work at your earliest convenience.\n\n" +
                        "If you have any questions or require clarification on any aspect of the task, feel free to reach out. " +
                        "Kindly provide periodic updates on your progress.\n\n" +
                        "Thank you, and I look forward to your successful completion of this assignment.\n\n" +
                        "Best regards,\n" +
                        "Human Resources");
        notification.setSubject("Task Assignment: " + taskAssignedEvent.getTaskName());
        notification.setSendTo(taskAssignedEvent.getUserName());
        return notification;
    }

    public static NotificationResponse mapNotificationToNotificationResponse(Notification notification) {
        NotificationResponse  notificationResponse = new NotificationResponse();
        notificationResponse.setBody(notification.getBody());
        notificationResponse.setSubject(notification.getSubject());
        notificationResponse.setSendTo(notification.getSendTo());
        return notificationResponse;
    }

    public static Notification mapRegisterEvent(RegisterUserEvent registerUserEvent) {
        Notification notification = new Notification();
        notification.setBody("Welcome to Task Management System, " + registerUserEvent.getUsername() + ". We are excited to have you on board.");
        notification.setSubject("Welcome to Task Management System");
        notification.setSendTo(registerUserEvent.getUsername());
        return notification;
    }


}
