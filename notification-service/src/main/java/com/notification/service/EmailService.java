package com.notification.service;

import com.notification.dto.MessageDTO;

public interface EmailService {

    void sendEmail(MessageDTO messageDTO);
}
