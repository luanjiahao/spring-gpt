package com.example.springgpt.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class ChatSession {

    @Id
    private String sessionId;

    private String maskId;

    private String title;

    @OneToMany(mappedBy = "session",cascade = CascadeType.PERSIST)
    private List<ChatMessage> messages;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getMaskId() {
        return maskId;
    }

    public void setMaskId(String maskId) {
        this.maskId = maskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ChatMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ChatMessage> messages) {
        this.messages = messages;
    }
}
