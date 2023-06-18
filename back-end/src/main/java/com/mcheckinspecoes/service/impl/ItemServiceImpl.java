package com.mcheckinspecoes.service.impl;

import com.mcheckinspecoes.model.Inspection;
import com.mcheckinspecoes.model.Item;
import com.mcheckinspecoes.model.enums.Status;
import com.mcheckinspecoes.repository.InspectionRepository;
import com.mcheckinspecoes.repository.ItemRepository;
import com.mcheckinspecoes.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    private final InspectionRepository inspectionRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, InspectionRepository inspectionRepository) {
        this.itemRepository = itemRepository;
        this.inspectionRepository = inspectionRepository;
    }

    @Override
    public Item save(MultipartFile itemImage, String itemName, String status, String observations, Long inspectionId) throws IOException {

        Item item = new Item();

        item.setItemImage(itemImage.getBytes());
        item.setItemName(itemName);
        if(status.equals("1")){
            item.setStatus(Status.COMPLIANT);
        } else{
            item.setStatus(Status.NOT_COMPLIANT);
        }
        item.setObservations(observations);
        Inspection inspection = inspectionRepository.findById(inspectionId).get();
        item.setInspection(inspection);
        return itemRepository.save(item);
    }

    @Override
    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item update(Long id, Item updatedItem) {
        Item item = itemRepository.findById(id).orElse(null);
        if (item != null) {
            item.setItemName(updatedItem.getItemName());
            item.setStatus(updatedItem.getStatus());
            item.setObservations(updatedItem.getObservations());
            return itemRepository.save(item);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }
}
