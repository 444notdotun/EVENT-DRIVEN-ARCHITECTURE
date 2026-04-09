package com.managmentapplication.taskmanagement.dtos.response;

import com.managmentapplication.taskmanagement.data.models.TaskStatus;
import lombok.Data;

@Data
public class NotificationResponse {
    private String TaskName;
    private String TaskDescription;
    private TaskStatus taskStatus;
    private String userId;
    private String projectName;
}
