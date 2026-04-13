package com.managmentapplication.taskmanagement.events.eventModels;

import com.managmentapplication.taskmanagement.data.models.Role;
import lombok.Data;

@Data
public class RegisterUserEvent {
    private String Username;
    private String LastName;
    private String FirstName;
    private Role role;
}
