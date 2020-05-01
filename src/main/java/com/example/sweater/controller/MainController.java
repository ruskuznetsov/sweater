package com.example.sweater.controller;

import com.example.sweater.domain.Message;
import com.example.sweater.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Message> allMessages = messageRepo.findAll();
        model.put("messages", allMessages);
        return "main";
    }

    @PostMapping("/main")
    public String addMessage(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        Message message = new Message(text, tag);
        messageRepo.save(message);
        Iterable<Message> allMessages = messageRepo.findAll();
        model.put("messages", allMessages);
        return "main";
    }

    @PostMapping("filter")
    public String filterMessages(@RequestParam String tag, Map<String, Object> model) {
        Iterable<Message> filteredByTag;
        if (tag != null && !tag.isEmpty()) {
            filteredByTag = messageRepo.findByTag(tag);
        } else {
            filteredByTag = messageRepo.findAll();
        }
        model.put("messages", filteredByTag);
        return "main";
    }
}
