package com.acc.genithon.service;

import com.acc.genithon.model.Item;
import com.acc.genithon.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ItemRepository repository;

    public Item saveItem(Item item) {
        return repository.save(item);
    }

    public Item getItem(String name) {
        return repository.findItemByName(name);
    }
}
