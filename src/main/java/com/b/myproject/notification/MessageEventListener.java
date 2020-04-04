package com.b.myproject.notification;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.broker.BrokerAvailabilityEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.*;

@Component
public class MessageEventListener {

    @EventListener
    public void getSesstionConnectEvent(SessionConnectEvent sessionConnectEvent){
        System.out.println(sessionConnectEvent);
    }

    @EventListener
    public void getBrokerAvailabilityEvent(BrokerAvailabilityEvent brokerAvailabilityEvent){
        System.out.println(brokerAvailabilityEvent);
    }

    @EventListener
    public void getSessionConnectedEvent(SessionConnectedEvent sessionConnectedEvent){
        System.out.println(sessionConnectedEvent);
    }

    @EventListener
    public void getSessionSubscribeEvent(SessionSubscribeEvent sessionSubscribeEvent){
        System.out.println(sessionSubscribeEvent);
    }
    @EventListener
    public void getSessionUnsubscribeEvent(SessionUnsubscribeEvent sessionUnsubscribeEvent){
        System.out.println(sessionUnsubscribeEvent);
    }
    @EventListener
    public void getSessionDisconnectEvent(SessionDisconnectEvent sessionDisconnectEvent){
        System.out.println(sessionDisconnectEvent);
    }
}
