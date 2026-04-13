package com.managmentapplication.taskmanagement.data.repository;

import com.managmentapplication.taskmanagement.data.models.Audition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRepository extends JpaRepository<Audition, String> {
}
