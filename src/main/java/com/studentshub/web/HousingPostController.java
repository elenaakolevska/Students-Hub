package com.studentshub.web;

import com.studentshub.model.HousingPost;
import com.studentshub.service.HousingPostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/housing-posts")
public class HousingPostController {

    private final HousingPostService service;

    public HousingPostController(HousingPostService service) {
        this.service = service;
    }

    @GetMapping
    public String getAll(Model model) {
        List<HousingPost> posts = service.findAll();
        model.addAttribute("posts", posts);
        return "housing-posts/list";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Long id, Model model) {
        HousingPost post = service.findById(id);
        model.addAttribute("post", post);
        return "housing-posts/details";
    }


    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new HousingPost());
        return "housing-posts/form";
    }

    @PostMapping
    public String create(@ModelAttribute HousingPost post) {
        service.create(post);
        return "redirect:/housing-posts";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        HousingPost post = service.findById(id);
        model.addAttribute("post", post);
        return "housing-posts/form";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute HousingPost post) {
        service.update(id, post);
        return "redirect:/housing-posts";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/housing-posts";
    }
}
