package com.mcheckinspecoes.controller;

import com.mcheckinspecoes.model.User;
import com.mcheckinspecoes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getById(@PathVariable(value = "userId")Long id) {
        User user = userService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

//    @DeleteMapping("{userId}")
//    public ResponseEntity<Object> deleteUser(@PathVariable(value = "userId") Long id) {
//        Optional<User> user = userService.findById(id);
//    }


//    void delete(User user);
//
//    void save(User user);
//
//    boolean existsByUsername(String name);
//
//    boolean existsByEmail(String email);
}
