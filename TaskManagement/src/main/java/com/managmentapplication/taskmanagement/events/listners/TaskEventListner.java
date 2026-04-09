package com.managmentapplication.taskmanagement.events.listners;

import com.managmentapplication.taskmanagement.events.eventModels.TaskAssignedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TaskEventListner {

    @EventListener
    public void taskAssignedEvent(TaskAssignedEvent taskAssignedEvent) {
        System.out.println(taskAssignedEvent.toString());
    }
}
