package com.managmentapplication.taskmanagement.data.models;

import lombok.Data;

@Data
public class Notification{
    private String sendTo;
    private String subject;
    private String body;

}
