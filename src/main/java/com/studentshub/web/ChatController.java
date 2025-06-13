package com.studentshub.web;

import com.studentshub.model.Message;
import com.studentshub.model.User;
import com.studentshub.repository.UserRepository;
import com.studentshub.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//
//@Controller
//@RequestMapping("/chat")
//public class ChatController {
//    @Autowired
//    ChatService chatService;
//    @Autowired
//    UserRepository userRepo;
//
////    @GetMapping
////    public String dashboard(Principal principal, Model model) {
////        User user = userRepo.findByUsername(principal.getName()).orElseThrow();
////        model.addAttribute("chatPartners", chatService.getChatPartners(user));
////        return "chat/dashboard";
////    }
//    @GetMapping
//    public String dashboard(Principal principal, Model model) {
//        if (principal == null) {
//            return "redirect:/users/login";
//        }
//
//        Optional<User> optionalUser = userRepo.findByUsername(principal.getName());
//        if (optionalUser.isEmpty()) {
//            return "redirect:/users/login?error=user_not_found";
//        }
//
//        User currentUser = optionalUser.get();
//
//        // Find all users EXCEPT the current one
//        List<User> allUsers = userRepo.findAll()
//                .stream()
//                .filter(u -> !u.getUsername().equals(currentUser.getUsername()))
//                .toList();
//
//        model.addAttribute("chatPartners", allUsers);
//        model.addAttribute("currentUser", currentUser);
//        return "chat/dashboard";
//    }
//    //        Optional<User> optionalUser = userRepo.findByUsername(principal.getName());
////        if (optionalUser.isEmpty()) {
////            // User not found, redirect or show error page
////            return "redirect:/login?error=user_not_found";
////        }
////        User user = optionalUser.get();
////
////        List<User> chatPartners = chatService.getChatPartners(user);
////        if (chatPartners == null) {
////            chatPartners = new ArrayList<>();
////        }
////        model.addAttribute("chatPartners", chatPartners);
//
//    @GetMapping("/{username}")
//    public String chat(@PathVariable String username, Principal principal, Model model) {
//        User me = userRepo.findByUsername(principal.getName()).orElseThrow();
//
//        Optional<User> optionalOther = userRepo.findByUsername(username);
//        if (optionalOther.isEmpty()) {
//            // User not found, redirect to chat dashboard or show an error page
//            return "redirect:/chat";
//        }
//
//        User other = optionalOther.get();
//
//        model.addAttribute("receiver", other);
//        model.addAttribute("messages", chatService.getChat(me, other));
//        return "chat/chat";
//    }
//
//
//}

@Controller
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @Autowired
    private UserRepository userRepo;

    // Show dashboard with optional chat if username is provided
    @GetMapping({"", "/{username}"})
    public String dashboardOrChat(@PathVariable(required = false) String username,
                                  Principal principal,
                                  Model model) {
        if (principal == null) {
            return "redirect:/users/login";
        }

        Optional<User> optionalUser = userRepo.findByUsername(principal.getName());
        if (optionalUser.isEmpty()) {
            return "redirect:/users/login?error=user_not_found";
        }
        User currentUser = optionalUser.get();

        // All users except current
        List<User> allUsers = userRepo.findAll()
                .stream()
                .filter(u -> !u.getUsername().equals(currentUser.getUsername()))
                .toList();

        model.addAttribute("chatPartners", allUsers);
        model.addAttribute("currentUser", currentUser);

        if (username != null && !username.isBlank()) {
            Optional<User> optionalOther = userRepo.findByUsername(username);
            if (optionalOther.isPresent()) {
                User other = optionalOther.get();
                model.addAttribute("receiver", other);
                model.addAttribute("messages", chatService.getChat(currentUser, other));
            }
            else {
                // If user not found, just show dashboard without chat
                model.addAttribute("receiver", null);
                model.addAttribute("messages", null);
            }
        } else {
            // No user selected for chat
            model.addAttribute("receiver", null);
            model.addAttribute("messages", null);
        }

        return "chat/dashboard";  // your combined Thymeleaf template name
    }
}
