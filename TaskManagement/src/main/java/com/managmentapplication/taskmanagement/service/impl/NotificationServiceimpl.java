package com.managmentapplication.taskmanagement.service.impl;

import com.managmentapplication.taskmanagement.data.models.Notification;
import com.managmentapplication.taskmanagement.dtos.response.NotificationResponse;
import com.managmentapplication.taskmanagement.events.eventModels.TaskAssignedEvent;
import com.managmentapplication.taskmanagement.service.ServiceInterface.NotificationService;
import com.managmentapplication.taskmanagement.utils.Mapper;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceimpl implements NotificationService {
    @Override
    public NotificationResponse sendNotification(TaskAssignedEvent taskAssignedEvent) {
        Notification notification = Mapper.mapNotification(taskAssignedEvent);
        return Mapper.mapNotificationToNotificationResponse(notification);
    }
}
