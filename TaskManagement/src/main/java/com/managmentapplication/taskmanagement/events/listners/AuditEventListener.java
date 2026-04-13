package com.managmentapplication.taskmanagement.events.listners;

import com.managmentapplication.taskmanagement.events.eventModels.RegisterUserEvent;
import com.managmentapplication.taskmanagement.events.eventModels.TaskAssignedEvent;
import com.managmentapplication.taskmanagement.service.ServiceInterface.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AuditEventListener {
    @Autowired
    private AuditService auditService;

    @Async
    @EventListener
    public void logEvent(TaskAssignedEvent taskAssignedEvent){
        auditService.AuditLog(taskAssignedEvent);
    }

    @Async
    @EventListener
    public void logEvent(RegisterUserEvent registerUserEvent){
        auditService.AuditLog(registerUserEvent);
    }
}
