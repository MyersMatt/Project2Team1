package com.revature.controllers;

import com.revature.models.items.StoreItem;
import com.revature.services.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/items")
@CrossOrigin("*")
public class ItemController {
    private final ItemService itemService;
    private static final Logger logger = Logger.getLogger(ItemController.class.getName());

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/add")
    public @ResponseBody StoreItem addItem(@RequestBody StoreItem item) {
        Optional<StoreItem> newItem = itemService.add(item);
        return newItem.orElse(null);
    }

    @PostMapping("/delete")
    public @ResponseBody Boolean deleteItem(@RequestBody int itemId) {
        return itemService.delete(itemId);
    }

    @PatchMapping("/update")
    public @ResponseBody StoreItem updateItem(@RequestBody LinkedHashMap<String, Integer> body) {
        Optional<StoreItem> item = itemService.getItem(body.get("itemId"));
        Optional<StoreItem> updatedItem = Optional.empty();
        if (item.isPresent()) {
            int quantity = item.get().getItemQuantity() + body.get("quantity");
            item.get().setItemQuantity(quantity);
            updatedItem = itemService.update(item.get());
        }
        return updatedItem.orElse(null);
    }

    @GetMapping("/getItem")
    public @ResponseBody StoreItem getItem(@RequestBody int itemId) {

        return itemService.getItem(itemId).orElse(null);
    }

    @PatchMapping("/updateBoughtItems")
    public @ResponseBody void updateBoughtItems(@RequestBody LinkedHashMap<Integer, Integer> body){
        logger.log(Level.INFO, "Got here with body: " + body);
        itemService.updatePurchasedItems(body);
    }
    @GetMapping("/getAllItems")
    public @ResponseBody List<StoreItem> getAllItems() {
        return itemService.getAll();
    }
}
