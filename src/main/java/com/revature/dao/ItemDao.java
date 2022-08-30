package com.revature.dao;

import com.revature.models.items.StoreItem;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.util.List;

@Transactional
@Repository("ItemDaoBean")
public class ItemDao implements Dao<StoreItem> {


    private final SessionFactory sessionFactory;

    @Autowired
    public ItemDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(StoreItem storeItem) {
        sessionFactory.getCurrentSession().save(storeItem);
    }

    @Override
    public List<StoreItem> read() {
        return sessionFactory.getCurrentSession().createQuery("from StoreItem ", StoreItem.class).list();
    }

    @Override
    public void update(StoreItem storeItem) {
        sessionFactory.getCurrentSession().update(storeItem);
    }

    @Override
    public void delete(StoreItem storeItem) {
        sessionFactory.getCurrentSession().delete(storeItem);
    }

    @Override
    public ResultSet runCustomSql(String sql) {
        // TODO Auto-generated method stub
        return null;
    }

}
