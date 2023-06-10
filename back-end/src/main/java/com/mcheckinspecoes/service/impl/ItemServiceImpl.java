package com.mcheckinspecoes.service.impl;

import com.mcheckinspecoes.model.Item;
import com.mcheckinspecoes.model.enums.Status;
import com.mcheckinspecoes.repository.ItemRepository;
import com.mcheckinspecoes.service.ItemService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public Item update(Item item) {
        try {
            Optional<Item> optionalItem = itemRepository.findById(item.getId());
            if (optionalItem.isPresent()) {
                Item oldItem = optionalItem.get();
                oldItem.setItemName(item.getItemName());

                if (item.getStatus().toString().equals("1")) {
                    oldItem.setStatus(Status.COMPLIANT);
                } else {

                    oldItem.setStatus(Status.NOT_COMPLIANT);
                }
                oldItem.setObservations(item.getObservations());
                return itemRepository.save(oldItem);
            } else {
                throw new IllegalArgumentException("Item not found with ID: " + item.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(NoSuchElementException::new);
        itemRepository.delete(item);
    }

    @Override
    public Long save(MultipartFile itemImage) throws IOException {

        byte[] imageBytes = itemImage.getBytes();

        Item item = new Item();
        item.setItemImage(imageBytes);

        Item savedItem = itemRepository.save(item);

        return savedItem.getId();
    }

    @Override
    public boolean existsByItemName(String name) {
        return itemRepository.existsByItemName(name);
    }

}
