package com.revature.controllers;

import com.revature.models.items.OrderList;
import com.revature.services.item.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@Controller
@RequestMapping("/OrderHistory")
@CrossOrigin("*")
public class OrderHistoryController {
    private final OrderHistoryService orderHistoryService;

    @Autowired
    public OrderHistoryController(OrderHistoryService orderHistoryService){
        this.orderHistoryService = orderHistoryService;
    }

    @PostMapping("/AddHistory")
    public @ResponseBody void addHistory(@RequestBody LinkedHashMap<String, String> body){
        orderHistoryService.addHistory(body);
    }

    @PostMapping("/GetHistory")
    public @ResponseBody List<OrderList> getHistory(@RequestBody LinkedHashMap<String,String> body){
        return orderHistoryService.getHistory(body);
    }
}
