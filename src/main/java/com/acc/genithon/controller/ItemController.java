package com.acc.genithon.controller;

import com.acc.genithon.model.Item;
import com.acc.genithon.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService service;

    @PostMapping("/")
    public Item saveItem(@RequestBody Item item) {
        return service.saveItem(item);
    }

    @GetMapping
    public Item getItem(@RequestParam("name") String name) {
        return service.getItem(name);
    }
}
