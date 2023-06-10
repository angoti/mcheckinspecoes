package com.mcheckinspecoes.controller;

import com.mcheckinspecoes.model.Item;
import com.mcheckinspecoes.service.ItemService;
import com.mcheckinspecoes.service.impl.ItemServiceImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item")
public class ItemController implements ItemService {

    private final ItemServiceImpl itemServiceImpl;

    public ItemController(ItemServiceImpl itemServiceImpl) {
        this.itemServiceImpl = itemServiceImpl;
    }

    @Override
    @GetMapping
    public List<Item> findAll() {
        return itemServiceImpl.findAll();
    }

    @Override
    @GetMapping("{id}")
    public Optional<Item> findById(@PathVariable Long id) {
        return itemServiceImpl.findById(id);
    }

    @Override
    @PutMapping("/update")
    public Item update(@RequestBody Item item) {
        return itemServiceImpl.update(item);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        itemServiceImpl.delete(id);
    }

    @PostMapping("/save-image")
    public Long save(@RequestParam() MultipartFile itemImage) throws IOException {
        return itemServiceImpl.save(itemImage);
    }

    @Override
    @GetMapping("/name")
    public boolean existsByItemName(@RequestBody String name) {
        return itemServiceImpl.existsByItemName(name);
    }
}
