package com.revature.models.items;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.revature.models.users.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order_lists")
public class OrderList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "list_name")
    private String listName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "list_item_junction",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "item_id")}
    )
    private List<StoreItem> orderList;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public OrderList() {
        this.orderList = new ArrayList<>();
    }

    public OrderList(Integer orderId, String listName, List<StoreItem> orderList, User user) {
        this.orderId = orderId;
        this.listName = listName;
        this.orderList = orderList;
        this.user = user;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public List<StoreItem> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<StoreItem> orderList) {
        this.orderList = orderList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "OrderList{" +
                "orderId=" + orderId +
                ", listName='" + listName + '\'' +
                ", orderList=" + orderList +
                ", user=" + user +
                '}';
    }
}
