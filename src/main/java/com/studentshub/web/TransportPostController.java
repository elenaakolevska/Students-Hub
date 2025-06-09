package com.studentshub.web;

import com.studentshub.model.TransportPost;
import com.studentshub.service.TransportPostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/transport-posts")
public class TransportPostController {

    private final TransportPostService transportPostService;

    public TransportPostController(TransportPostService transportPostService) {
        this.transportPostService = transportPostService;
    }

    @GetMapping
    public String listAll(Model model) {
        model.addAttribute("transportPosts", transportPostService.findAll());
        return "transport-posts/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("transportPost", new TransportPost());
        return "transport-posts/form";
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute TransportPost transportPost) {
        transportPostService.create(transportPost);
        return "redirect:/transport-posts";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        TransportPost post = transportPostService.findById(id);
        model.addAttribute("transportPost", post);
        return "transport-posts/form";
    }

    @PostMapping("/update")
    public String updatePost(@ModelAttribute TransportPost transportPost) {
        transportPostService.update(transportPost.getId(), transportPost);
        return "redirect:/transport-posts";
    }

    @PostMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        transportPostService.delete(id);
        return "redirect:/transport-posts";
    }
}
