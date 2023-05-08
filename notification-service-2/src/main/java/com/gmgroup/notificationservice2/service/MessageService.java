package com.gmgroup.notificationservice2.service;

import com.gmgroup.notificationservice2.model.MessageDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @KafkaListener(id = "notificationGroup", topics = "notification")
    public void listen(MessageDTO messageDTO) {
        System.out.println(messageDTO.getTo());
        System.out.println(messageDTO.getSubject());
        System.out.println(messageDTO.getContent());

    }
}
