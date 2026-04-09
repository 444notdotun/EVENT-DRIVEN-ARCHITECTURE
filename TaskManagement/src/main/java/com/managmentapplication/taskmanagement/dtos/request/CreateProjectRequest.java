package com.managmentapplication.taskmanagement.dtos.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateProjectRequest {
    @NotBlank
    private String projectName;
    @NotBlank
    private String projectDescription;
}
