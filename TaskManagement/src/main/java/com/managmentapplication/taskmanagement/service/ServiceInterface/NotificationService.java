package com.managmentapplication.taskmanagement.service.ServiceInterface;

import com.managmentapplication.taskmanagement.dtos.response.NotificationResponse;
import com.managmentapplication.taskmanagement.events.eventModels.RegisterUserEvent;
import com.managmentapplication.taskmanagement.events.eventModels.TaskAssignedEvent;

public interface NotificationService {
    NotificationResponse sendNotification(TaskAssignedEvent taskAssignedEvent);
    NotificationResponse sendNotification(RegisterUserEvent registerUserEvent);
}
