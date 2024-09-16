package com.example.springgpt.controller;

import com.example.springgpt.entity.ChatMessage;
import com.example.springgpt.entity.ChatSession;
import com.example.springgpt.entity.Mask;
import com.example.springgpt.repository.ChatMessageRepository;
import com.example.springgpt.repository.ChatSessionRepository;
import com.example.springgpt.repository.MaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@Controller
@RequestMapping("/session")
public class ChatSessionController {
    @Autowired
    private ChatSessionRepository chatSessionRepository;

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addSession (@RequestBody ChatSession session) {
        chatSessionRepository.save(session);
        return "Saved";
    }

    @PostMapping(path="/message/add")
    public @ResponseBody String addMessage (@RequestParam String sessionId, @RequestBody ChatMessage message) {
        ChatSession session = chatSessionRepository.findById(sessionId).get();
        message.setSession(session);
        chatMessageRepository.save(message);
        return "Saved";
    }

    @PostMapping(path="/delete")
    public @ResponseBody String deleteSession (@RequestParam String sessionId) {
        chatSessionRepository.deleteById(sessionId);
        return "Deleted";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<ChatSession> getAllSessions() {
        return chatSessionRepository.findAll();
    }


}
