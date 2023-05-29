package com.mcheckinspecoes.service;

import com.mcheckinspecoes.model.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    List<Item> findAll();

    Optional<Item> findById(Long id);

    void delete(Item item);

    void save(Item item);

    boolean existsByItemName(String name);
}
