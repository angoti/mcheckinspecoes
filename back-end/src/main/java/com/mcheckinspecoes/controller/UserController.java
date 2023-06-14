package com.mcheckinspecoes.controller;

import com.mcheckinspecoes.model.User;
import com.mcheckinspecoes.service.UserService;
import com.mcheckinspecoes.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController implements UserService {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @Override
    @GetMapping
    public List<User> findAll() {
        return userServiceImpl.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable Long id) {
        return userServiceImpl.findById(id);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        userServiceImpl.delete(id);
    }

    @Override
    @PostMapping
    public void save(@RequestBody User user) {
        userServiceImpl.save(user);
    }

    @Override
    @PutMapping("/update/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        return userServiceImpl.update(id,user);
    }

    @Override
    @GetMapping("/email")
    public User findByName(@RequestBody String name) {
        return userServiceImpl.findByName(name);
    }

    @Override
    @GetMapping("/name")
    public User findByEmail(@RequestBody String email) {
        return userServiceImpl.findByEmail(email);
    }
}
