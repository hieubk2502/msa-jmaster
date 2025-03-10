package com.dev.account.service.client;

import com.dev.account.dto.MessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification-service", url = "http://localhost:8082/notification", fallback = NotificationServiceImpl.class)
public interface NotificationService {

    @PostMapping("/send-notification")
    void sendNotification(@RequestBody MessageDTO messageDTO);
}

@Component
@Slf4j
class NotificationServiceImpl implements NotificationService {
    @Override
    public void sendNotification(MessageDTO messageDTO) {
        // fallback
        log.error("Notification Service is slow");
    }
}