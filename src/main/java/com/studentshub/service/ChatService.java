package com.studentshub.service;

import com.studentshub.model.Message;
import com.studentshub.model.User;


import java.util.List;

public interface ChatService {
    List<Message> getChat(User u1, User u2);

    void send(User sender, User receiver, String content);

    List<User> getChatPartners(User user);


}
