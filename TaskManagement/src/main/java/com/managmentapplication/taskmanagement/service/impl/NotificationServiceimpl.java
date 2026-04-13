package com.managmentapplication.taskmanagement.service.impl;

import com.managmentapplication.taskmanagement.data.models.Notification;
import com.managmentapplication.taskmanagement.dtos.response.NotificationResponse;
import com.managmentapplication.taskmanagement.events.eventModels.RegisterUserEvent;
import com.managmentapplication.taskmanagement.events.eventModels.TaskAssignedEvent;
import com.managmentapplication.taskmanagement.service.ServiceInterface.NotificationService;
import com.managmentapplication.taskmanagement.utils.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationServiceimpl implements NotificationService {
    @Override
    public NotificationResponse sendNotification(TaskAssignedEvent taskAssignedEvent) {
        Notification notification = Mapper.mapNotification(taskAssignedEvent);
        log.info("Notification Sent");
        return Mapper.mapNotificationToNotificationResponse(notification);
    }

    @Override
    public NotificationResponse sendNotification(RegisterUserEvent registerUserEvent) {
        Notification notification = Mapper.mapRegisterEvent(registerUserEvent);
        log.info("Notification Sent");
        return Mapper.mapNotificationToNotificationResponse(notification);
    }
}
