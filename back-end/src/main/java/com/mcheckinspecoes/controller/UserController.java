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
    public ResponseEntity<User> getById(@PathVariable(value = "userId") Long id) {
        Optional<User> user = userService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user.get());
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "userId") Long id) {
        Optional<User> userOptional = userService.findById(id);
        if (!userOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        } else {
            userService.delete(userOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso");
        }
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Object> update(@PathVariable(value = "userId") Long id,
                                         @RequestBody User user) {
        Optional<User> userOptional = userService.findById(id);
        if (userOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        } else {
            var userModel = userOptional.get();
            userModel.setName(user.getName());
            userModel.setEmail(user.getEmail());
            userService.save(userModel);
            return ResponseEntity.status(HttpStatus.OK).body(userModel);
        }
    }

    @PutMapping("/{userId}/password")
    public ResponseEntity<Object> updatePassword(@PathVariable Long id,
                                                 @RequestBody User user) {
        Optional<User> userOptional = userService.findById(id);
        if (!userOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        } else {
            var userModel = userOptional.get();
            userModel.setPassword(user.getPassword());
            userService.save(userModel);
            return ResponseEntity.status(HttpStatus.OK).body("Senha atualizada com sucesso");
        }
    }
}
