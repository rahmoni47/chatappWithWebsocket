package com.h80.chatapp.config;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.h80.chatapp.Enum.MessageType;
import com.h80.chatapp.model.ChatMessage;

import lombok.extern.slf4j.Slf4j;



@Component
@Slf4j
@EnableWebSocketMessageBroker
public class DisconnectEventListener {

    private final SimpMessageSendingOperations messager;

    public DisconnectEventListener(SimpMessageSendingOperations messager) {
        this.messager = messager;
    }
    
    @EventListener
    public void HandleDisconnectSession(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = (String) headerAccessor.getSessionAttributes().get("username");
        if (username != null) {
            log.info("the user :" + username + " left");
            ChatMessage chatMessage = ChatMessage.builder()
                                            .type(MessageType.Disconnected)
                                            .sender(username)
                    .build();
            messager.convertAndSend("/topic/public",chatMessage);
        }
    }
}
