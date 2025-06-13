package com.studentshub.service.impl;

import com.studentshub.model.ChatMessage;
import com.studentshub.model.Message;
import com.studentshub.model.User;
import com.studentshub.repository.MessageRepository;
import com.studentshub.repository.UserRepository;
import com.studentshub.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    private MessageRepository messageRepo;

    @Autowired
    private UserRepository userRepo;

    @Override
    public List<Message> getChat(User u1, User u2) {
        return messageRepo.findChatBetweenUsers(u1, u2);
    }

    @Override
    public void send(User sender, User receiver, String content) {
        Message msg = new Message();
        msg.setSender(sender);
        msg.setReceiver(receiver);
        msg.setContent(content);
        msg.setTimestamp(LocalDateTime.now());
        messageRepo.save(msg);
    }

    @Override
    public List<User> getChatPartners(User user) {
        return messageRepo.findChatPartners(user);
    }




}
