package com.kocfinans.notificationservice.service;

import com.kocfinans.notificationservice.core.Notification;
import com.kocfinans.notificationservice.core.NotificationFactory;
import com.kocfinans.notificationservice.dto.NotificationRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.Not;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest
class NotificationServiceTest {

    @Autowired
    private NotificationService notificationService;
    @MockBean
    private List<Notification> notificationList;
    @MockBean
    private NotificationFactory notificationFactory;
    @Test
    void sendNotification() {
        NotificationRequestDto notificationRequestDto = new NotificationRequestDto();
        notificationRequestDto.setLoanLimit(2222);
        notificationRequestDto.setNationalIdentityId("1234");
        notificationRequestDto.setNotificationCode("SMS_LOAN_APPLICATION_APPROVE");
        boolean notificationResponse = notificationService.sendNotification(notificationRequestDto);
        assertEquals(notificationResponse, false);

    }
}
