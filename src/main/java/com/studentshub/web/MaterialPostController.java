package com.studentshub.web;

import com.studentshub.model.MaterialPost;
import com.studentshub.service.MaterialPostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/material-posts")
public class MaterialPostController {

    private final MaterialPostService service;

    public MaterialPostController(MaterialPostService service) {
        this.service = service;
    }

    @GetMapping
    public List<MaterialPost> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public MaterialPost getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public MaterialPost create(@RequestBody MaterialPost post) {
        return service.create(post);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody MaterialPost post) {
        service.update(post.getId(), post);
        return "redirect:/material-posts";
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

