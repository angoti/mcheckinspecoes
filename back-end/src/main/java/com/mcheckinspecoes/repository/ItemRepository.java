package com.mcheckinspecoes.repository;

import com.mcheckinspecoes.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    boolean existsByItemName(String name);
}
