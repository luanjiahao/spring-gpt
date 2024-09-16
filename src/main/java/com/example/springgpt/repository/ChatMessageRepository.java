package com.example.springgpt.repository;

import com.example.springgpt.entity.ChatMessage;
import org.springframework.data.repository.CrudRepository;

public interface ChatMessageRepository extends CrudRepository<ChatMessage,String> {
}
