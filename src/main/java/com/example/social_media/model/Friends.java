package com.example.social_media.model;

import jakarta.persistence.*;

@Entity
public class Friends {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "userSend",nullable = false)
    private Users userSend;
    @ManyToOne
    @JoinColumn(name = "userReceive",nullable = false)
    private Users userReceive;

    public Friends() {
    }

    public Friends(Long id, Users userSend, Users userReceive) {
        this.id = id;
        this.userSend = userSend;
        this.userReceive = userReceive;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Users getUserSend() {
        return userSend;
    }

    public void setUserSend(Users userSend) {
        this.userSend = userSend;
    }

    public Users getUserReceive() {
        return userReceive;
    }

    public void setUserReceive(Users userReceive) {
        this.userReceive = userReceive;
    }
}
