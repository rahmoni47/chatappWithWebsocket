package com.h80.chatapp.model;

import com.h80.chatapp.Enum.MessageType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ChatMessage {
    private String sender;
    private String content;
    private MessageType type; 
}
