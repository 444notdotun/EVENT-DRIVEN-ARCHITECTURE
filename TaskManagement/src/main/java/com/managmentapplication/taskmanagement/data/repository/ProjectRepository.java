package com.managmentapplication.taskmanagement.data.repository;

import com.managmentapplication.taskmanagement.data.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project,String> {
    Optional<Project> findById(String id);
}
