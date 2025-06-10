package com.studentshub.config;

import com.studentshub.model.EventPost;
import com.studentshub.model.User;
import com.studentshub.model.enumerations.EventCategory;
import com.studentshub.model.enumerations.PostCategory;
import com.studentshub.repository.EventPostRepository;
import com.studentshub.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class DataInitializer {

    private final EventPostRepository eventPostRepository;
    private final UserRepository userRepository;

    public DataInitializer(EventPostRepository eventPostRepository, UserRepository userRepository) {
        this.eventPostRepository = eventPostRepository;
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void initData() {
        User adminUser = userRepository.findByUsername("admin")
                .orElseGet(() -> {
                    User admin = new User();
                    admin.setUsername("admin");
                    admin.setPassword("admin");
                    return userRepository.save(admin);
                });

        List<EventPost> posts = List.of(
                new EventPost(null, "Jazz Night", "An evening full of live jazz performances by local artists.",
                        LocalDateTime.now(), adminUser, PostCategory.EVENT, EventCategory.PARTY,
                        "Ohrid Cultural Center", false, 1500, "Ohrid Music Society",
                        "https://i.pinimg.com/736x/c8/4d/ff/c84dff6e4c07401a5dfa36061c71491a.jpg"),

                new EventPost(null, "Art Workshop", "Learn painting techniques in this free art workshop for beginners.",
                        LocalDateTime.now(), adminUser, PostCategory.EVENT, EventCategory.WORKSHOP,
                        "Gallery XYZ", true, 0, "Creative Minds",
                        "https://scandinavian-art-design.com/cdn/shop/files/PaintandPourBild.jpg?v=1709045781&width=533"),

                new EventPost(null, "Tech Conference 2025", "A 3-day conference covering the latest trends in AI and IoT.",
                        LocalDateTime.now(), adminUser, PostCategory.EVENT, EventCategory.DISCUSSION,
                        "Skopje Expo Center", false, 1200, "Tech Innovators",
                        "https://i.pinimg.com/originals/72/1b/93/721b933842f9dfce93caa3fe30f1f784.jpg"),

                new EventPost(null, "Marathon Run", "Join the annual marathon run for charity and fitness enthusiasts.",
                        LocalDateTime.now(), adminUser, PostCategory.EVENT, EventCategory.COMPETITION,
                        "City Park", false, 250, "City Sports Club",
                        "https://runnerstribe.com/wp-content/uploads/2016/11/CaseyWood.jpg"),

                new EventPost(null, "Book Fair", "Explore and buy books from local and international authors.",
                        LocalDateTime.now(), adminUser, PostCategory.EVENT, EventCategory.DISCUSSION,
                        "National Library", true, 0, "Library Association",
                        "https://images.unsplash.com/photo-1547126298-f0ae8a42c489?fm=jpg&q=60&w=3000&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8Ym9vayUyMGZhaXJ8ZW58MHx8MHx8fDA%3D"),

                new EventPost(null, "Culinary Festival", "Taste delicious dishes from Macedonian and international cuisine.",
                        LocalDateTime.now(), adminUser, PostCategory.EVENT, EventCategory.PARTY,
                        "Old Town Square", false, 100, "Gourmet Association",
                        "https://images.stockcake.com/public/b/9/5/b95fe362-ee89-48ac-bae3-acfe181981a8_large/food-truck-festival-stockcake.jpg")
        );

        eventPostRepository.saveAll(posts);
    }
}