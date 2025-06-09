package com.studentshub.web;
import com.studentshub.model.TutorPost;
import com.studentshub.service.TutorPostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tutor-posts")
public class TutorPostController {

    private final TutorPostService tutorPostService;

    public TutorPostController(TutorPostService tutorPostService) {
        this.tutorPostService = tutorPostService;
    }

    @GetMapping
    public String listAllTutorPosts(Model model) {
        model.addAttribute("tutorPosts", tutorPostService.findAll());
        return "tutor-posts/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("tutorPost", new TutorPost());
        return "tutor-posts/form";
    }

    @PostMapping("/create")
    public String createTutorPost(@ModelAttribute TutorPost tutorPost) {
        tutorPostService.create(tutorPost);
        return "redirect:/tutor-posts";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        TutorPost post = tutorPostService.findById(id);
        model.addAttribute("tutorPost", post);
        return "tutor-posts/form";
    }

    @PostMapping("/update")
    public String updateTutorPost(@ModelAttribute TutorPost tutorPost) {
        tutorPostService.update(tutorPost.getId(), tutorPost);
        return "redirect:/tutor-posts";
    }

    @PostMapping("/delete/{id}")
    public String deleteTutorPost(@PathVariable Long id) {
        tutorPostService.delete(id);
        return "redirect:/tutor-posts";
    }
}
