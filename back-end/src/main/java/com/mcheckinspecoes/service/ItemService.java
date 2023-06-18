package com.mcheckinspecoes.service;

import com.mcheckinspecoes.model.Item;
import com.mcheckinspecoes.model.enums.Status;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ItemService {


    Item save(MultipartFile itemImage, String itemName, String status, String observations, Long inspectionId) throws IOException;

    Optional<Item> findById(Long id);

    List<Item> findAll();

    Item update(Long id, Item item);

    void delete(Long id);

}
