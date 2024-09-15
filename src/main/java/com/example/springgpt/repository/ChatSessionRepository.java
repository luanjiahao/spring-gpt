package com.example.springgpt.repository;

import com.example.springgpt.entity.ChatSession;
import org.springframework.data.repository.CrudRepository;

public interface ChatSessionRepository extends CrudRepository<ChatSession,String> {
}
