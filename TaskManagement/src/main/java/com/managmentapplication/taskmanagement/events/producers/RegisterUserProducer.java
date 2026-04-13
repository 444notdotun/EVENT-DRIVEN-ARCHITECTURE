package com.managmentapplication.taskmanagement.events.producers;

import com.managmentapplication.taskmanagement.events.eventModels.RegisterUserEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class RegisterUserProducer {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void registerUserEvent(RegisterUserEvent registerUserEvent) {
        applicationEventPublisher.publishEvent(registerUserEvent);
    }


}
