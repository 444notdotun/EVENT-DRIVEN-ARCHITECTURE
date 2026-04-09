package com.managmentapplication.taskmanagement.data.models;

import lombok.Data;

@Data
public class Notification {
    private String TaskName;
    private String TaskDescription;
    private TaskStatus taskStatus;
    private String userId;
    private String projectName;
}
