package com.mcheckinspecoes.controller;

import com.mcheckinspecoes.model.User;
import com.mcheckinspecoes.service.UserService;
import com.mcheckinspecoes.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController implements UserService {

    private final UserServiceImpl userServiceImpls;

    public UserController(UserServiceImpl userServiceImpls) {
        this.userServiceImpls = userServiceImpls;
    }

    @Override
    @GetMapping
    public List<User> findAll() {
        return userServiceImpls.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable Long id) {
        return userServiceImpls.findById(id);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        userServiceImpls.delete(id);
    }

    @Override
    @PostMapping
    public void save(@RequestBody User user) {
        userServiceImpls.save(user);
    }

    @Override
    @PutMapping("/update/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        return userServiceImpls.update(id, user);
    }

    @Override
    @GetMapping("/name")
    public boolean existsByUsername(@RequestBody String name) {
        return userServiceImpls.existsByUsername(name);
    }

    @Override
    @GetMapping("/email")
    public boolean existsByEmail(@RequestBody String email) {
        return userServiceImpls.existsByEmail(email);
    }
}
