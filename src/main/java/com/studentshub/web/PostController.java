package com.studentshub.web;
import com.studentshub.model.*;
import com.studentshub.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;
    private final UserService userService;

    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping
    public String getAllPosts(Model model) {
        // You may want to load all posts if needed
        return "posts/list";
    }

    @GetMapping("/create")
    public String showCreateForm(@RequestParam("type") String type, Model model) {
        Post post;

        switch (type.toLowerCase()) {
            case "event":
                post = new EventPost();
                break;
            case "housing":
                post = new HousingPost();
                break;
            case "internship":
                post = new InternshipPost();
                break;
            case "material":
                post = new MaterialPost();
                break;
            case "transport":
                post = new TransportPost();
                break;
            case "tutor":
                post = new TutorPost();
                break;
            default:
                throw new IllegalArgumentException("Invalid post type: " + type);
        }

        model.addAttribute("post", post);
        model.addAttribute("type", type);
        return "posts/create";
    }

// PRIMER HTML
    /*
    <form action="#" method="get">
        <select name="type">
            <option value="event">Event Post</option>
            <option value="job">Job Post</option>
        </select>
        <button type="submit">Create</button>
    </form>

     */
@PostMapping("/posts/create")
public String createPost(@ModelAttribute Post post, Principal principal) {
    User owner = userService.getUserByUsername(principal.getName());

    
    post.setOwner(owner);
    post.setCreatedAt(LocalDateTime.now());
    
    postService.createPost(post);
    return "redirect:/posts";
}


    @GetMapping("/{id}")
    public String getPostDetails(@PathVariable Long id, Model model) {
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "posts/details";
    }

    @GetMapping("/my-posts")
    public String getMyPosts(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/login";
        }

        String username = principal.getName();
        List<Post> myPosts = postService.getPostsByUsername(username);
        model.addAttribute("posts", myPosts);
        return "posts/my-posts";
    }

    @PostMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id); // или како ти е имплементирано
        return "redirect:/posts/my-posts"; // или каде и да сакаш да пренасочи после бришење
    }



}