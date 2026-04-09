package com.managmentapplication.taskmanagement.service.ServiceInterface;

import com.managmentapplication.taskmanagement.data.models.Project;
import com.managmentapplication.taskmanagement.data.models.Users;
import com.managmentapplication.taskmanagement.data.repository.ProjectRepository;
import com.managmentapplication.taskmanagement.data.repository.UserRepository;
import com.managmentapplication.taskmanagement.dtos.request.CreateTaskRequest;
import com.managmentapplication.taskmanagement.dtos.response.CreateTaskResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class TaskServiceTest {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskService taskService;

    CreateTaskRequest createTaskRequest;
    String projectId;
    String userId;

    @BeforeEach
    void setUp() {
        Project project = new Project();
        projectRepository.save(project);
        Users users = new Users();
        users.setUsername("ade");
        userRepository.save(users);
        createTaskRequest = new CreateTaskRequest();
        createTaskRequest.setTaskDescription("get saas done and deploy");
        createTaskRequest.setTaskName("building saas");
        projectId = project.getProjectId();
        userId = users.getUsername();
    }


    @Test
    void testThatTaskCanBeCreated() {
        CreateTaskResponse createTaskResponse = taskService.createTask(projectId, userId, createTaskRequest);
        assertNotNull(createTaskResponse);
        assertEquals(createTaskResponse.getTaskName(), "building saas");

    }
}