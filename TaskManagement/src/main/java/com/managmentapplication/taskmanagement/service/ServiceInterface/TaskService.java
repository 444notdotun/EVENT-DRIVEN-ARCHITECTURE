package com.managmentapplication.taskmanagement.service.ServiceInterface;

import com.managmentapplication.taskmanagement.dtos.request.AssignTaskRequest;
import com.managmentapplication.taskmanagement.dtos.request.CreateTaskRequest;
import com.managmentapplication.taskmanagement.dtos.response.AssignTaskResponse;
import com.managmentapplication.taskmanagement.dtos.response.CreateTaskResponse;

public interface TaskService {
    CreateTaskResponse createTask(String projectId, CreateTaskRequest createTaskRequest);

    AssignTaskResponse assignTask(AssignTaskRequest assignTaskRequest,String taskId, String projectId);
}
