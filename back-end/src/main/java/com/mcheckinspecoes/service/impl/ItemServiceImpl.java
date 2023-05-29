package com.mcheckinspecoes.service.impl;

import com.mcheckinspecoes.model.Item;
import com.mcheckinspecoes.repository.ItemRepository;
import com.mcheckinspecoes.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    ItemRepository itemRepository;

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
            Item oldItem = itemRepository.findById(item.getId()).get();
            oldItem.setItemName(item.getItemName());
            oldItem.setItemImage(item.getItemImage());
            oldItem.setStatus(item.getStatus());
            oldItem.setObservations(item.getObservations());
            itemRepository.save(oldItem);
            return oldItem;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Item item) {
        itemRepository.delete(item);
    }

    @Override
    public void save(Item item) {
        itemRepository.save(item);
    }

    @Override
    public boolean existsByItemName(String name) {
        return itemRepository.existsByItemName(name);
    }
}
