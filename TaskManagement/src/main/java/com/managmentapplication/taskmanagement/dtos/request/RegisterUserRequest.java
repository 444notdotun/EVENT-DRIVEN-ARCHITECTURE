package com.managmentapplication.taskmanagement.dtos.request;

import com.managmentapplication.taskmanagement.data.models.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterUserRequest {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private  String username;
    @NotBlank
    private String password;
    @NotBlank
    private Role role;
}
