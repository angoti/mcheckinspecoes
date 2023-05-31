package com.mcheckinspecoes.service;

import com.mcheckinspecoes.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    User findById(Long id);

    void delete(User user);

    void save(User user);

    boolean existsByUsername(String name);

    boolean existsByEmail(String email);
}
