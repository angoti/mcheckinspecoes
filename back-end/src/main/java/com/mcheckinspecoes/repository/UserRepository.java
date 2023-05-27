package com.mcheckinspecoes.mcheckinspecoes.repository;

import com.mcheckinspecoes.mcheckinspecoes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
