package com.managmentapplication.taskmanagement.data.models;

import com.managmentapplication.taskmanagement.utils.Generator;
import com.managmentapplication.taskmanagement.utils.GeneratorType;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Task {
    @Id
    private String TaskId;
    private String TaskName;
    private String TaskDescription;
    private TaskStatus taskStatus;
    @ManyToOne
    @JoinColumn(name = "userId")
    private Users userId;
    @ManyToOne
    @JoinColumn(name = "projectId")
    private Project project;

    public Task(){
        this.taskStatus = TaskStatus.PENDING;
    }

    @PrePersist
    public void prePersist(){
        this.TaskId = Generator.generate(GeneratorType.TASK);
    }

}
