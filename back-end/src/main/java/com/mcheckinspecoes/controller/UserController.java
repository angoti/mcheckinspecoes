package com.mcheckinspecoes.controller;

import com.mcheckinspecoes.model.User;
import com.mcheckinspecoes.service.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping
    public User create(@RequestBody User user){
        return userServiceImpl.save(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userServiceImpl.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getById(@PathVariable(value = "userId") Long id) {
        Optional<User> user = userServiceImpl.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user.get());
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "userId") Long id) {
        Optional<User> userOptional = userServiceImpl.findById(id);
        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        } else {
            userServiceImpl.delete(userOptional.get().getId());
            return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso");
        }
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<Object> update(@PathVariable(value = "userId") Long id,
                                         @RequestBody User user) {
        Optional<User> userOptional = userServiceImpl.findById(id);
        if (userOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        } else {
            var userModel = userOptional.get();
            userModel.setUsername(user.getUsername());
            userModel.setEmail(user.getEmail());
            userServiceImpl.save(userModel);
            return ResponseEntity.status(HttpStatus.OK).body(userModel);
        }
    }

    @PutMapping("/{userId}/password")
    public ResponseEntity<Object> updatePassword(@PathVariable Long id,
                                                 @RequestBody User user) {
        Optional<User> userOptional = userServiceImpl.findById(id);
        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        } else {
            var userModel = userOptional.get();
            userModel.setPassword(user.getPassword());
            userServiceImpl.save(userModel);
            return ResponseEntity.status(HttpStatus.OK).body("Senha atualizada com sucesso");
        }
    }
}
