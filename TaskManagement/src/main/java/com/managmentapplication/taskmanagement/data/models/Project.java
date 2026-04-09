package com.managmentapplication.taskmanagement.data.models;

import com.managmentapplication.taskmanagement.utils.Generator;
import com.managmentapplication.taskmanagement.utils.GeneratorType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@Entity
@Data
public class Project {
    @Id
    private String projectId;
    private String projectName;
    private String projectDescription;
    @CreationTimestamp
    private LocalDateTime projectStartDate;
    private LocalDateTime projectEndDate;
    @ManyToOne
    @JoinColumn(name = "userId")
    private Users users;
    private ProjectStatus projectStatus;

    public Project() {
        this.projectStatus = ProjectStatus.NOT_COMPLETED;
    }


    @PrePersist
    public void prePersist(){
        this.projectId = Generator.generate(GeneratorType.PROJECT);
    }
}
