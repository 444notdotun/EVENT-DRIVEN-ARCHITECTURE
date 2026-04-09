package com.managmentapplication.taskmanagement.events.producers;

import com.managmentapplication.taskmanagement.events.eventModels.TaskAssignedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class TaskEventProducer {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void TaskAssignedEvent(TaskAssignedEvent taskAssignedEvent) {
        applicationEventPublisher.publishEvent(taskAssignedEvent);
    }
}
