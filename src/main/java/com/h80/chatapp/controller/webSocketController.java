package com.h80.chatapp.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.h80.chatapp.model.ChatMessage;

@Controller
public class webSocketController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage handleSendMessage(@Payload ChatMessage message) {
        return message;
    }
    
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage handleAddUser(@Payload ChatMessage message,StompHeaderAccessor accessor) {
        accessor.getSessionAttributes().put("username", message.getSender());
        return message;
    }
}
