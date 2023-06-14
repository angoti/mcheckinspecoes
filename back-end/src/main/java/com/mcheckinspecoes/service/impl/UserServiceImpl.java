package com.mcheckinspecoes.service.impl;

import com.mcheckinspecoes.model.User;
import com.mcheckinspecoes.repository.UserRepository;
import com.mcheckinspecoes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User update(Long id, User user) {
        try {
            Optional<User> optionalUser = userRepository.findById(id);
            if (optionalUser.isPresent()) {
                User oldUser = optionalUser.get();
                oldUser.setUsername(user.getUsername());
                oldUser.setPassword(user.getPassword());
                oldUser.setEmail(user.getEmail());
                return userRepository.save(oldUser);
            } else {
                throw new IllegalArgumentException("Enterprise not found with ID: " + user.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User findByName(String name) {
        User user = userRepository.findByUsername(name);
        System.out.println(user);
        return user;
    }

    @Override
    public User findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        System.out.println(user);
        return user;
    }
}
