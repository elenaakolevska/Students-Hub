package com.studentshub.web;

import com.studentshub.model.EventPost;
import com.studentshub.model.enumerations.EventCategory;
import com.studentshub.service.EventPostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/event-posts")
public class EventPostController {

    private final EventPostService eventPostService;

    public EventPostController(EventPostService eventPostService) {
        this.eventPostService = eventPostService;
    }

    @GetMapping
    public String listEventPosts(@RequestParam(required = false) EventCategory category, Model model) {
        List<EventPost> posts = (category == null) ?
                eventPostService.getAllEventPosts() :
                eventPostService.getEventPostsByCategory(category);
        model.addAttribute("eventPosts", posts);
        return "event-posts/list";
    }


    @GetMapping("/{id}")
    public String viewEventPost(@PathVariable Long id, Model model) {
        model.addAttribute("eventPost", eventPostService.getEventPostById(id));
        return "event-posts/details";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("eventPost", new EventPost());
        model.addAttribute("categories", EventCategory.values());


        return "event-posts/form";
    }

    @PostMapping
    public String createEventPost(@ModelAttribute EventPost eventPost) {
        eventPostService.createEventPost(eventPost);
        return "redirect:/event-posts";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("eventPost", eventPostService.getEventPostById(id));
        model.addAttribute("categories", EventCategory.values());

        return "event-posts/form";
    }

    @PostMapping("/update")
    public String updateEventPost(@ModelAttribute("eventPost") EventPost eventPost) {
        eventPostService.updateEventPost(eventPost.getId(), eventPost);
        return "redirect:/event-posts";
    }


    @PostMapping("/delete/{id}")
    public String deleteEventPost(@PathVariable Long id) {
        eventPostService.deleteEventPost(id);
        return "redirect:/event-posts";
    }
}

