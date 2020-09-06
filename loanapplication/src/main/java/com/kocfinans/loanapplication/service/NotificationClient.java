package com.kocfinans.loanapplication.service;

import com.kocfinans.loanapplication.dto.NotificationRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "notification",url = "#{'${client.notification.url}'}")
@RequestMapping("/notification")
public interface NotificationClient {

    @RequestMapping(method = RequestMethod.POST, value =   "/sendNotification", produces = "application/json")
    boolean sendNotification(@RequestBody NotificationRequestDto notificationRequestDto);

}
