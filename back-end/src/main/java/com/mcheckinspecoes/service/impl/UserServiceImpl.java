package com.mcheckinspecoes.service.impl;

import com.mcheckinspecoes.model.User;
import com.mcheckinspecoes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public void delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(NoSuchElementException::new);
        userRepository.delete(user);
    }

    public User save(User user) {
        userRepository.save(user);
        return user;
    }

    public User update(User user) {
        try {
           User oldUser = userRepository.findById(user.getId()).get();
           oldUser.setEmail(user.getEmail());
           oldUser.setUsername(user.getUsername());
           oldUser.setPassword(user.getPassword());
           userRepository.save(oldUser);
           return oldUser;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public boolean existsByUsername(String name){
        return userRepository.existsByUsername(name);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

}
