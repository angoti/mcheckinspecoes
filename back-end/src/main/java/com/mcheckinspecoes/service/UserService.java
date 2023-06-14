package com.mcheckinspecoes.service;

import com.mcheckinspecoes.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    Optional<User> findById(Long id);

    void delete(Long id);

    void save(User user);

    User update(Long id, User user);

    User findByName(String name);

    User findByEmail(String email);
}
