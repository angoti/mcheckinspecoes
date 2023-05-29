package com.mcheckinspecoes.repository;

import com.mcheckinspecoes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsername(String name);
    boolean existsByEmail(String email);
}
