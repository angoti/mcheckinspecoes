package com.mcheckinspecoes.service.impl;

import com.mcheckinspecoes.model.User;
import com.mcheckinspecoes.repository.UserRepository;
import com.mcheckinspecoes.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

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
        User user = userRepository.findById(id).orElseThrow(NoSuchElementException::new);
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
                oldUser.setEmail(user.getEmail());
                oldUser.setUsername(user.getUsername());
                oldUser.setPassword(user.getPassword());
                return userRepository.save(oldUser);
            } else {
                throw new IllegalArgumentException("User not found with ID: " + user.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public boolean existsByUsername(String name){
        return userRepository.existsByUsername(name);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

}
