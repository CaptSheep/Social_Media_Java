package com.example.social_media.model;

import jakarta.persistence.*;

@Entity
public class Friends {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user",nullable = false)
    private Users users;

    public Friends() {
    }

    public Friends(Long id, Users users) {
        this.id = id;
        this.users = users;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public Users getUser() {
        return users;
    }

    public void setUser(Users users) {
        this.users = users;
    }
}
