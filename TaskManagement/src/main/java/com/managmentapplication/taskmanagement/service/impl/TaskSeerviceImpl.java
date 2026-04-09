package com.managmentapplication.taskmanagement.service.impl;

import com.managmentapplication.taskmanagement.data.models.Project;
import com.managmentapplication.taskmanagement.data.models.Task;
import com.managmentapplication.taskmanagement.data.models.Users;
import com.managmentapplication.taskmanagement.data.repository.TaskRepository;
import com.managmentapplication.taskmanagement.dtos.request.AssignTaskRequest;
import com.managmentapplication.taskmanagement.dtos.request.CreateTaskRequest;
import com.managmentapplication.taskmanagement.dtos.response.AssignTaskResponse;
import com.managmentapplication.taskmanagement.dtos.response.CreateTaskResponse;
import com.managmentapplication.taskmanagement.events.eventModels.TaskAssignedEvent;
import com.managmentapplication.taskmanagement.events.producers.TaskEventProducer;
import com.managmentapplication.taskmanagement.service.ServiceInterface.TaskService;
import com.managmentapplication.taskmanagement.utils.Mapper;
import com.managmentapplication.taskmanagement.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class TaskSeerviceImpl implements TaskService {
    @Autowired
    private Validator  validator;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskEventProducer taskEventProducer;

    @Override
    public CreateTaskResponse createTask(String projectId ,CreateTaskRequest createTaskRequest) {
        Project project =validator.validateProject(projectId);
        Task task = Mapper.mapCreateTaskWithRequest(project,createTaskRequest);
        taskRepository.save(task);
        return Mapper.mapTaskToCreateTaskResponse(task);
    }

    @Override
    public AssignTaskResponse assignTask(AssignTaskRequest assignTaskRequest,String taskId,String  projectId) {
        Users users =validator.validateUser(assignTaskRequest.getUserId());
        Project project =validator.validateProject(projectId);
        Task task = validator.validateTask(taskId);
        task.setUserId(users);
        taskRepository.save(task);
        TaskAssignedEvent taskAssignedEvent = Mapper.mapTaskToEvent(task,users,project);
       taskEventProducer.TaskAssignedEvent(taskAssignedEvent);
        return Mapper.mapTaskToAssignTAskResponse(task);
    }
}
