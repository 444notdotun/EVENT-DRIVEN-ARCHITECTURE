package com.managmentapplication.taskmanagement.service.ServiceInterface;

import com.managmentapplication.taskmanagement.dtos.request.CreateTaskRequest;
import com.managmentapplication.taskmanagement.dtos.response.CreateTaskResponse;

public interface TaskService {


    CreateTaskResponse createTask(String projectId, String userId, CreateTaskRequest createTaskRequest);
}
