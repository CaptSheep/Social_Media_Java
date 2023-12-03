package com.example.social_media.service;

import com.example.social_media.model.Message;

import java.util.Optional;

public interface MessageService extends BaseInterface<Message>{

    Optional<Message> findByMessage(String message);
}
