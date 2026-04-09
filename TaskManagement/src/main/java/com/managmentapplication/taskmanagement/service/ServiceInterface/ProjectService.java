package com.managmentapplication.taskmanagement.service.ServiceInterface;

import com.managmentapplication.taskmanagement.dtos.request.CreateProjectRequest;
import com.managmentapplication.taskmanagement.dtos.request.CreateTaskRequest;
import com.managmentapplication.taskmanagement.dtos.response.CreateProjectServiceResponse;
import com.managmentapplication.taskmanagement.dtos.response.CreateTaskResponse;

public interface ProjectService {
    CreateProjectServiceResponse createProject(CreateProjectRequest createProjectRequest, String username);

    CreateTaskResponse createTask(CreateTaskRequest createTask, String projectId);
}
