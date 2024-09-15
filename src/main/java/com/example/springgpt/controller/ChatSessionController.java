package com.example.springgpt.controller;

import com.example.springgpt.entity.ChatSession;
import com.example.springgpt.entity.Mask;
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

    @GetMapping("/get")
    public @ResponseBody ChatSession getSessionById(@RequestParam String id) {
        Optional<ChatSession> session = chatSessionRepository.findById(id);
        if (session.isPresent()) {
            return session.get();
        } else {
            return null;
        }
    }
}
