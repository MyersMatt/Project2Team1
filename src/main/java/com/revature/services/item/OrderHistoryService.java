package com.revature.services.item;

import com.revature.dao.ItemDao;
import com.revature.dao.OrderListDao;
import com.revature.dao.UserDao;
import com.revature.models.items.OrderList;
import com.revature.models.items.StoreItem;
import com.revature.models.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service("OrderHistoryServiceBean")
public class OrderHistoryService {
    private static final Logger logger = Logger.getLogger(OrderHistoryService.class.getName());
    private final UserDao userDao;
    private final ItemDao itemDao;
    private final OrderListDao orderListDao;

    @Autowired
    public OrderHistoryService(UserDao userDao, ItemDao itemDao, OrderListDao orderListDao){
        this.userDao = userDao;
        this.itemDao = itemDao;
        this.orderListDao = orderListDao;
    }
    public void addHistory(LinkedHashMap<String, String> body) {
        Integer id = Integer.parseInt(body.get("userId"));
        List<User> users = userDao.read();
        User user = null;
        for(User u : users) if(u.getId().equals(id)){ user = u;}
        List<StoreItem> items = itemDao.read();
        List<StoreItem> newList = new ArrayList<>();
        for(Map.Entry<String,String> entry: body.entrySet()){
            if(entry.getKey().equals("userId")) continue;
            for(StoreItem item : items)
                if(Integer.parseInt(entry.getKey()) == item.getItemId()){
                    newList.add(item);
                }
        }
        if(user != null) {
            OrderList orderList = new OrderList(newList, user);
            orderListDao.create(orderList);
        }
    }

    public List<OrderList> getHistory(LinkedHashMap<String, String> body) {
        Integer id = Integer.parseInt(body.get("userId"));
        logger.log(Level.INFO, "Got User ID: " + id);
        List<OrderList> orders = orderListDao.read();
        List<OrderList> userOrders = new ArrayList<>();
        for(OrderList order: orders) {
            logger.log(Level.INFO,"Looking at order");
            logger.log(Level.INFO, order.toString());
            if(order.getUser().getId().equals(id)) userOrders.add(order);
        }
        logger.log(Level.INFO,"Found these order with for user with id: " +id);
        logger.log(Level.INFO,userOrders.toString());
        return userOrders;
    }
}
