package com.example.springgpt.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ChatSession {

    @Id
    private String sessionId;

    private String topic;

    @OneToOne
    @JoinColumn(name = "maskId",referencedColumnName = "maskId")
    private Mask mask;

    private long createTime;

    private long lastUpdate;


    @OneToMany(mappedBy = "session",cascade = CascadeType.PERSIST)
    private List<ChatMessage> messages;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Mask getMask() {
        return mask;
    }

    public void setMask(Mask mask) {
        this.mask = mask;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<ChatMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ChatMessage> messages) {
        this.messages = messages;
    }
}
