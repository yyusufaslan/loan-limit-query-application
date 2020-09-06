package com.kocfinans.notificationservice.core;

import com.kocfinans.notificationservice.dto.NotificationRequestDto;
import com.kocfinans.notificationservice.model.NotificationCode;

public interface Notification {

    String createBody(NotificationRequestDto request);

    NotificationCode getCode();

}
