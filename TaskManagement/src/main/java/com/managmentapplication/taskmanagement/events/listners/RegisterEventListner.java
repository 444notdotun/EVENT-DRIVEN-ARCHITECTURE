package com.managmentapplication.taskmanagement.events.listners;

import com.managmentapplication.taskmanagement.data.models.Notification;
import com.managmentapplication.taskmanagement.events.eventModels.RegisterUserEvent;
import com.managmentapplication.taskmanagement.events.producers.RegisterUserProducer;
import com.managmentapplication.taskmanagement.service.ServiceInterface.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class RegisterEventListner {
    @Autowired
    private NotificationService notificationService;

    @Async
    @EventListener
    public void registerUserEvent(RegisterUserEvent registerUserEvent){
        notificationService.sendNotification(registerUserEvent);
    }
}
