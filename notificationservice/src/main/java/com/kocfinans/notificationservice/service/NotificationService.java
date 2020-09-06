package com.kocfinans.notificationservice.service;

import com.kocfinans.notificationservice.core.Notification;
import com.kocfinans.notificationservice.core.NotificationFactory;
import com.kocfinans.notificationservice.dto.NotificationRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

@Service
public class NotificationService {

    private static final Logger logger = LogManager.getLogger(NotificationService.class);

    @Value("${url.notificationUrl}")
    private String url;

    @Autowired
    private NotificationFactory notificationFactory;

    public boolean sendNotification(NotificationRequestDto notificationRequestDto){
        Notification notification = notificationFactory.createNotification(notificationRequestDto.getNotificationCode());
        String notificationBody = (Objects.nonNull(notification) ? notification.createBody(notificationRequestDto) : null);

        logger.info(notificationRequestDto.getNationalIdentityId() + " T.C numarali müşteriye bildirim gönderildi..");

        /**
         *
         * SMS service hizmeti sağlayıcısına post isteği atılır ve dönen cevaba göre true false döneriz.
         * Hizmet sağlayıcısı olmadığı için doğrudan true değer setledim.
         *
         * RestTemplate restTemplate = new RestTemplate();
         * HttpEntity<String> request = new HttpEntity<>(notificationBody);
         * ResponseEntity<Objects> serviceResponse = restTemplate.exchange(url, HttpMethod.POST, request, Objects.class);
         * if (Objects.isNull(serviceResponse)){
         *
         * **/

        return Objects.nonNull(notificationBody);
    }
}
