package com.studentshub.web;
import com.studentshub.model.*;
import com.studentshub.service.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;
    private final UserService userService;
    private final GroupChatService groupChatService;

    public MessageController(MessageService messageService, UserService userService, GroupChatService groupChatService) {
        this.messageService = messageService;
        this.userService = userService;
        this.groupChatService = groupChatService;
    }

    @GetMapping("/group/{groupId}")
    public String getGroupMessages(@PathVariable Long groupId, Model model) {
        GroupChat group = groupChatService.getGroupChatById(groupId);
        List<Message> messages = messageService.getMessagesInGroup(group);
        model.addAttribute("group", group);
        model.addAttribute("messages", messages);
        return "messages/groupMessages";
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam Long senderId,
                              @RequestParam Long receiverId,
                              @RequestParam Long groupId,
                              @RequestParam String content) {
        User sender = userService.getUserById(senderId);
        User receiver = userService.getUserById(receiverId);
        GroupChat group = groupChatService.getGroupChatById(groupId);
        messageService.sendMessage(sender, receiver, group, content);
        return "redirect:/messages/group/" + groupId;
    }
}

