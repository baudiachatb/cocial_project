package com.b.myproject.endpoint.controller.notification;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    @MessageMapping("/app/chat")
    @SendTo("/topic/hub")
    public String demo(String value){
        System.out.println(value);
        return "aaaaaa";
    }
}
