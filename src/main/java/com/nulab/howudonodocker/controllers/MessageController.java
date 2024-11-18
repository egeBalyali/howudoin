package com.nulab.howudonodocker.controllers;


import com.nulab.howudonodocker.model.Message;
import com.nulab.howudonodocker.repository.MessageRepository;
import com.nulab.howudonodocker.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @GetMapping
    public ResponseEntity<List<Message>> getConversation(@RequestParam String userId1, @RequestParam String userId2) {
        return ResponseEntity.ok(messageService.getConversation(userId1, userId2));
    }
    @GetMapping("all")
    public ResponseEntity<List<Message>> getAllConversation() {
        return ResponseEntity.ok(messageService.getAllMessages());
    }
    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody Message message) {
        messageService.sendMessage(message);
        return ResponseEntity.ok("Message sent.");
    }
}
