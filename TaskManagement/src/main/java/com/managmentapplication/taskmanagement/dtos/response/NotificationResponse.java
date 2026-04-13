package com.managmentapplication.taskmanagement.dtos.response;

import com.managmentapplication.taskmanagement.data.models.TaskStatus;
import lombok.Data;

@Data
public class NotificationResponse {
    private String sendTo;
    private String subject;
    private String body;
}
