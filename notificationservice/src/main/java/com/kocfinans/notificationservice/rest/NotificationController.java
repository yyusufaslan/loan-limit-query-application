package com.kocfinans.notificationservice.rest;

import com.kocfinans.notificationservice.dto.NotificationRequestDto;
import com.kocfinans.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("notification")
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @PostMapping("/sendNotification")
    public boolean sendNotification(@RequestBody NotificationRequestDto notificationRequestDto){
       return notificationService.sendNotification(notificationRequestDto);
    }


}
