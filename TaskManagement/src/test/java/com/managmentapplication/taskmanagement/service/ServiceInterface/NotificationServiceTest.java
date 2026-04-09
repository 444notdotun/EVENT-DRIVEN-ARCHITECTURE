package com.managmentapplication.taskmanagement.service.ServiceInterface;
import com.managmentapplication.taskmanagement.data.models.Notification;
import com.managmentapplication.taskmanagement.data.models.TaskStatus;
import com.managmentapplication.taskmanagement.dtos.response.NotificationResponse;
import com.managmentapplication.taskmanagement.events.eventModels.TaskAssignedEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class NotificationServiceTest {
    @Autowired
    private NotificationService notificationService;

    TaskAssignedEvent taskAssignedEvent;



    @Test
    void sendNotification() {
        taskAssignedEvent = new TaskAssignedEvent();
        taskAssignedEvent.setTaskName("Implement Login Feature");
        taskAssignedEvent.setTaskDescription("Create authentication using JWT");
        taskAssignedEvent.setTaskStatus(TaskStatus.IN_PROGRESS);
        taskAssignedEvent.setUserId("user123");
        taskAssignedEvent.setProjectName("Task Management System");
        NotificationResponse notificationRespnse = notificationService.sendNotification(taskAssignedEvent);
        assertNotNull(notificationRespnse);

    }



}