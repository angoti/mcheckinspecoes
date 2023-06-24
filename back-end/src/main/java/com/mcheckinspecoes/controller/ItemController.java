package com.mcheckinspecoes.controller;

import com.mcheckinspecoes.model.Item;
import com.mcheckinspecoes.model.enums.Status;
import com.mcheckinspecoes.service.ItemService;
import com.mcheckinspecoes.service.impl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemServiceImpl itemService;

    @Autowired
    public ItemController(ItemServiceImpl itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public Item createItem(@RequestParam("itemImage") MultipartFile itemImage,
                                           @RequestParam("itemName") String itemName,
                                           @RequestParam("status") Integer status,
                                           @RequestParam("observations") String observations,
                                           @RequestParam("inspectionId") Long inspectionId) throws IOException {

        return itemService.save(itemImage, itemName, status, observations, inspectionId);
    }

    @GetMapping("/{id}")
    public Optional<Item> getItemById(@PathVariable Long id) {
        return itemService.findById(id);
    }

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.findAll();
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item updatedItem) {
        return itemService.update(id, updatedItem);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.delete(id);
    }

//    @PostMapping(value = "/save-image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public Item save(@RequestParam() MultipartFile itemImage) throws IOException {
//        return itemService.save(itemImage);
//    }

}
