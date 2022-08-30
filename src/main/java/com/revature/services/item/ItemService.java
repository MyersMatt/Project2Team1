package com.revature.services.item;

import com.revature.dao.ItemDao;
import com.revature.models.items.StoreItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("ItemServiceBean")
public class ItemService {

    private final ItemDao itemDao;

    @Autowired
    public ItemService(ItemDao itemDao){this.itemDao = itemDao;}
    public Optional<StoreItem> add(StoreItem item) {
        itemDao.create(item);
        List<StoreItem> itemList = itemDao.read();
        for(StoreItem i : itemList) if(i.getItemName().equals(item.getItemName())) return Optional.of(i);
        return Optional.empty();
    }

    public Boolean delete(int itemId) {
        List<StoreItem> items = itemDao.read();
        for(StoreItem item: items){ if(item.getItemId() == itemId){ itemDao.delete(item); return true;}}
        return false;
    }

    public Optional<StoreItem> update(StoreItem item) {
        itemDao.update(item);
        List<StoreItem> itemList = itemDao.read();
        for(StoreItem i : itemList) if(i.getItemId() == item.getItemId()) return Optional.of(i);
        return Optional.empty();
    }

    public Optional<StoreItem> getItem(int itemId) {
        List<StoreItem> items = itemDao.read();
        for(StoreItem item: items){if(item.getItemId() == itemId) return Optional.of(item);}
        return Optional.empty();
    }
}
