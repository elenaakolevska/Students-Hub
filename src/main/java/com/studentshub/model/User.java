package com.studentshub.model;

import jakarta.persistence.*;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    private String password;
    private String education;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "owner")
    private List<Post> posts;

    @OneToMany(mappedBy = "user")
    private List<Favorite> favorites;

    @OneToMany(mappedBy = "sender")
    private List<Message> sentMessages;

    @OneToMany(mappedBy = "user")
    private List<GroupChatMembers> groupMemberships;

    public User() {
    }

    public User(Long id, String firstName, String lastName, String username, String email, String password, String education, LocalDateTime createdAt, List<Post> posts, List<Favorite> favorites, List<Message> sentMessages, List<GroupChatMembers> groupMemberships) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.education = education;
        this.createdAt = createdAt;
        this.posts = posts;
        this.favorites = favorites;
        this.sentMessages = sentMessages;
        this.groupMemberships = groupMemberships;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Favorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Favorite> favorites) {
        this.favorites = favorites;
    }

    public List<Message> getSentMessages() {
        return sentMessages;
    }

    public void setSentMessages(List<Message> sentMessages) {
        this.sentMessages = sentMessages;
    }

    public List<GroupChatMembers> getGroupMemberships() {
        return groupMemberships;
    }

    public void setGroupMemberships(List<GroupChatMembers> groupMemberships) {
        this.groupMemberships = groupMemberships;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
