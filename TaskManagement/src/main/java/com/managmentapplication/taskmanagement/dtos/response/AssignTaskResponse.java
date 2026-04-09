package com.managmentapplication.taskmanagement.dtos.response;

import com.managmentapplication.taskmanagement.data.models.Project;
import com.managmentapplication.taskmanagement.data.models.TaskStatus;
import com.managmentapplication.taskmanagement.data.models.Users;
import lombok.Data;

@Data
public class AssignTaskResponse {
    private String TaskId;
    private String TaskName;
    private String TaskDescription;
    private TaskStatus taskStatus;
    private Users userId;
    private Project project;
}
