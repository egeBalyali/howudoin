package com.nulab.howudonodocker.service;

import com.nulab.howudonodocker.model.Message;
import com.nulab.howudonodocker.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public void sendMessage(Message message)
    {
        messageRepository.save(message);

    }
    public List<Message> getAllMessages()
    {
        return messageRepository.findAll();
    }
    public List<Message> getConversation(String user1Id, String user2Id)
    {
        return messageRepository.findByParticipants(user1Id, user2Id);
    }
}
