package com.example.social_media.service;

import java.util.Optional;

public interface BaseInterface<T> {
    void save(T t);
    T findAll ();
    Optional<T> findById(Long id);
    void delete();
}
