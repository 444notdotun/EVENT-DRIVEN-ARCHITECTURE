package com.managmentapplication.taskmanagement.service.impl;

import com.managmentapplication.taskmanagement.data.models.Project;
import com.managmentapplication.taskmanagement.data.models.Task;
import com.managmentapplication.taskmanagement.data.models.Users;
import com.managmentapplication.taskmanagement.data.repository.TaskRepository;
import com.managmentapplication.taskmanagement.dtos.request.CreateTaskRequest;
import com.managmentapplication.taskmanagement.dtos.response.CreateTaskResponse;
import com.managmentapplication.taskmanagement.service.ServiceInterface.TaskService;
import com.managmentapplication.taskmanagement.utils.Mapper;
import com.managmentapplication.taskmanagement.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskSeerviceImpl implements TaskService {
    @Autowired
    private Validator  validator;
    @Autowired
    private TaskRepository taskRepository;
    @Override
    public CreateTaskResponse createTask(String projectId, String userId, CreateTaskRequest createTaskRequest) {
        Users users =validator.validateUser(userId);
        Project project =validator.validateProject(projectId);
        Task task = Mapper.mapCreateTaskWithRequest(users,project,createTaskRequest);
        taskRepository.save(task);
        return Mapper.mapTaskToCreateTaskResponse(task);
    }
}
