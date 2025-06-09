package com.studentshub.web;


import com.studentshub.model.HousingPost;
import com.studentshub.model.MaterialPost;
import com.studentshub.service.HousingPostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/housing-posts")
public class HousingPostController {

    private final HousingPostService service;

    public HousingPostController(HousingPostService service) {
        this.service = service;
    }

    @GetMapping
    public List<HousingPost> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public HousingPost getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public HousingPost create(@RequestBody HousingPost post) {
        return service.create(post);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody HousingPost post) {
        service.update(post.getId(), post);
        return "redirect:/housing-posts";
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
