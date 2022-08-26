package com.revature.services.item;

import com.revature.models.items.StoreItem;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("ItemServiceBean")
public class ItemService {

    public Optional<StoreItem> add(StoreItem item) {
        return Optional.empty();
    }
}
