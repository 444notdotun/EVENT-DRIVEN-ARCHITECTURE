package com.managmentapplication.taskmanagement.dtos.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.managmentapplication.taskmanagement.data.models.ProjectStatus;
import com.managmentapplication.taskmanagement.data.models.Users;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@Data
public class CreateProjectServiceResponse {
    private String projectId;
    private String projectName;
    private String projectDescription;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime projectStartDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime projectEndDate;
    private String users;
    private ProjectStatus projectStatus;
}
