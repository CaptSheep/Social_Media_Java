package com.example.social_media.model;

import jakarta.persistence.*;

@Entity
public class Friend_List {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user",nullable = false)
    private Users users;

    @ManyToOne
    @JoinColumn(name = "friend",nullable = false)
    private Friends friends;

    public Friend_List() {
    }

    public Friend_List(Long id, Users users, Friends friends) {
        this.id = id;
        this.users = users;
        this.friends = friends;
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

    public Friends getFriend() {
        return friends;
    }

    public void setFriend(Friends friends) {
        this.friends = friends;
    }
}
