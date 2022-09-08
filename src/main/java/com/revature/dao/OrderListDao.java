package com.revature.dao;

import com.revature.models.items.OrderList;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.util.List;

@Transactional
@Repository("OrderListDaoBean")
public class OrderListDao implements Dao<OrderList> {

    private final SessionFactory sessionFactory;
    @Autowired
    public OrderListDao(SessionFactory sessionFactory){
        this.sessionFactory =sessionFactory;
    }

    @Override
    public void create(OrderList orderList) {
        sessionFactory.getCurrentSession().save(orderList);
    }

    @Override
    public List<OrderList> read() {
        return sessionFactory.getCurrentSession().createQuery("from OrderList",OrderList.class).list();
    }

    @Override
    public void update(OrderList orderList) {
        sessionFactory.getCurrentSession().update(orderList);
    }

    @Override
    public void delete(OrderList orderList) {
        sessionFactory.getCurrentSession().delete(orderList);

    }

    @Override
    public ResultSet runCustomSql(String sql) {
        return null;
    }
}
