package com.managmentapplication.taskmanagement.service.impl;

import com.managmentapplication.taskmanagement.data.models.Project;
import com.managmentapplication.taskmanagement.data.models.Users;
import com.managmentapplication.taskmanagement.data.repository.ProjectRepository;
import com.managmentapplication.taskmanagement.dtos.request.CreateProjectRequest;
import com.managmentapplication.taskmanagement.dtos.request.CreateTaskRequest;
import com.managmentapplication.taskmanagement.dtos.response.CreateProjectServiceResponse;
import com.managmentapplication.taskmanagement.dtos.response.CreateTaskResponse;
import com.managmentapplication.taskmanagement.service.ServiceInterface.ProjectService;
import com.managmentapplication.taskmanagement.service.ServiceInterface.TaskService;
import com.managmentapplication.taskmanagement.utils.Mapper;
import com.managmentapplication.taskmanagement.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private Validator validator;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private TaskService taskService;

    @Override
    public CreateProjectServiceResponse createProject(CreateProjectRequest createProjectRequest, String username) {
        Users users =validator.validateUser(username);
        Project project = Mapper.mapRequestToProject(createProjectRequest,users);
        projectRepository.save(project);
        return Mapper.mapCreateProjectResponseToproject(project);
    }

    @Override
    public CreateTaskResponse createTask(CreateTaskRequest createTask, String projectId, String username) {
        return taskService.createTask(projectId, username, createTask);
    }
}
