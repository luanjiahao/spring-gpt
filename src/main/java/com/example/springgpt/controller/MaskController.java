package com.example.springgpt.controller;


import com.example.springgpt.entity.ChatMessage;
import com.example.springgpt.entity.Mask;
import com.example.springgpt.repository.MaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/mask")
public class MaskController {

    @Autowired
    private MaskRepository maskRepository;

    @PostMapping(path="/add_all")
    public @ResponseBody String addAllMasks (@RequestBody List<Mask> maskList) {
        for (Mask mask : maskList) {
            for (ChatMessage chatMessage : mask.getContext()) {
                chatMessage.setMask(mask);
            }
        }
        maskRepository.saveAll(maskList);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Mask> getAllMasks() {
        return maskRepository.findAll();
    }
}
