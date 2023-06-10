package com.mcheckinspecoes.service;

import com.mcheckinspecoes.model.Item;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ItemService {

    List<Item> findAll();

    Optional<Item> findById(Long id);

    Item update(Item item);

    void delete(Long id);

    Long save(MultipartFile itemImage) throws IOException;

    boolean existsByItemName(String name);
}
