package com.managmentapplication.taskmanagement.events.eventModels;

import com.managmentapplication.taskmanagement.data.models.Project;
import com.managmentapplication.taskmanagement.data.models.TaskStatus;
import com.managmentapplication.taskmanagement.data.models.Users;
import lombok.Data;

@Data
public class TaskAssignedEvent {
    private String TaskName;
    private String TaskDescription;
    private TaskStatus taskStatus;
    private String userId;
    private String projectName;
}
