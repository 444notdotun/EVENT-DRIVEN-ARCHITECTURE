package com.managmentapplication.taskmanagement.dtos.response;

import com.managmentapplication.taskmanagement.data.models.Role;
import lombok.Data;

@Data
public class AuthResponse {
    private String userId;
    private String Username;
    private String LastName;
    private String FirstName;
    private String token;
    private Role role;
}
