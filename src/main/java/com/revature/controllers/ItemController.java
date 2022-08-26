package com.revature.controllers;

import com.revature.models.items.StoreItem;
import com.revature.services.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RequestMapping("/items")
@CrossOrigin("*")
public class ItemController {
    private final ItemService itemService;
    @Autowired
    public ItemController(ItemService itemService){ this.itemService = itemService;}

    @PostMapping("/add")
    public @ResponseBody StoreItem addItem(@RequestBody StoreItem item){
        Optional<StoreItem> newItem = itemService.add(item);
        return newItem.orElse(null);
    }

    @PostMapping("/delete")
    public @ResponseBody Boolean deleteItem(@RequestBody int itemId){
        return itemService.delete(itemId);
    }

    @PatchMapping("/update")
    public @ResponseBody Boolean updateItem(@ResponseBody StoreItem item){
        return itemService.update(item);
    }
}
