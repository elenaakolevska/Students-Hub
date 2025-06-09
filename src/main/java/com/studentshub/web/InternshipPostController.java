package com.studentshub.web;

import com.studentshub.model.InternshipPost;
import com.studentshub.service.InternshipPostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/internship-posts")
public class InternshipPostController {

    private final InternshipPostService service;

    public InternshipPostController(InternshipPostService service) {
        this.service = service;
    }

    @GetMapping
    public List<InternshipPost> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public InternshipPost getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public InternshipPost create(@RequestBody InternshipPost post) {
        return service.create(post);
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("internshipPost") InternshipPost internshipPost) {
        service.update(internshipPost.getId(), internshipPost);
        return "redirect:/internship-posts";
    }



    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
