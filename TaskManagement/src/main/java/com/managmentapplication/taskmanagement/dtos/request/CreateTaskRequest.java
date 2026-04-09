package com.managmentapplication.taskmanagement.dtos.request;

import lombok.Data;

@Data
public class CreateTaskRequest {
    private String TaskName;
    private String TaskDescription;
}

