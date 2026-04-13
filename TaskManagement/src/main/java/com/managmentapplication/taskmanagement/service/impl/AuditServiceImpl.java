package com.managmentapplication.taskmanagement.service.impl;

import com.managmentapplication.taskmanagement.data.models.Audition;
import com.managmentapplication.taskmanagement.data.repository.AuditRepository;
import com.managmentapplication.taskmanagement.service.ServiceInterface.AuditService;
import com.managmentapplication.taskmanagement.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditServiceImpl  implements AuditService {
    @Autowired
    private AuditRepository auditRepository;

    @Override
    public void AuditLog(Object event) {
        Audition audition = new Audition();
        audition.setAction(event.getClass().getSimpleName());
        auditRepository.save(audition);
    }
}
