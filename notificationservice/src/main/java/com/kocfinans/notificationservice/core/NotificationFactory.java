package com.kocfinans.notificationservice.core;

import com.kocfinans.notificationservice.model.NotificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotificationFactory {

    @Autowired
    private List<Notification> notificationList;

    public Notification createNotification(String notificationCode) {

        for (Notification notification : notificationList) {
            if (notification.getCode().toString().equals(notificationCode)) {
                return notification;
            }
        }
        return null;
    }

}
