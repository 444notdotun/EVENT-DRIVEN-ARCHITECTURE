package com.managmentapplication.taskmanagement.utils;

import com.managmentapplication.taskmanagement.data.models.Project;
import com.managmentapplication.taskmanagement.data.models.Task;
import com.managmentapplication.taskmanagement.data.models.Users;
import com.managmentapplication.taskmanagement.data.repository.ProjectRepository;
import com.managmentapplication.taskmanagement.data.repository.TaskRepository;
import com.managmentapplication.taskmanagement.data.repository.UserRepository;
import com.managmentapplication.taskmanagement.exception.UsersNotFound;
import com.managmentapplication.taskmanagement.exception.projectNotFound;
import com.managmentapplication.taskmanagement.exception.taskNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Validator {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProjectRepository  projectRepository;
    @Autowired
    private TaskRepository taskRepository;

    public Users validateUser(String Username){
        if(!userRepository.existsByUsername(Username)){
            throw new UsersNotFound("user not found");
        }
        return userRepository.findByUsername(Username).get();
    }
    public Project validateProject(String projectId){
        if(projectRepository.findById(projectId).isEmpty()){
            throw new projectNotFound("project not found");
        }
        return projectRepository.findById(projectId).get();
    }

    public Task validateTask(String taskId) {
        if(taskRepository.findById(taskId).isEmpty()){
            throw new taskNotFound("task not found");
        }
        return  taskRepository.findById(taskId).get();
    }
}
