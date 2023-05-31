package com.mcheckinspecoes.service.impl;

import com.mcheckinspecoes.model.User;
import com.mcheckinspecoes.repository.UserRepository;
import com.mcheckinspecoes.service.UserService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        User user = userRepository.findById(id).stream().findFirst().orElse(null);
        if(user == null) {
            throw new ObjectNotFoundException(id, "Usuário não encontrado!");
        }
        return user;
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User update(User user) {
        try {
           User oldUser = userRepository.findById(user.getId()).get();
           oldUser.setEmail(user.getEmail());
           oldUser.setName(user.getName());
           oldUser.setPassword(user.getPassword());
           userRepository.save(oldUser);
           return oldUser;

        }catch (Exception e){
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
