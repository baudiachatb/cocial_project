package com.b.myproject.notification;

import com.b.myproject.notification.entities.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@Component
public class Scheduling {
    @Autowired
    SimpMessagingTemplate messagingTemplate;

    @Scheduled(fixedDelay = 3000)
    public void send(){
        System.out.println("start!");
        messagingTemplate.convertAndSend("/topic/hub", new ChatMessage(ChatMessage.MessageType.CHAT, "aa", "bbb"));
    }
}
