package com.revature.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.items.StoreItem;
import com.revature.utils.HibernateUtil;

public class ItemDao implements Dao<StoreItem>{

	@Override
	public void create(StoreItem t) throws SQLException {
		Session session = HibernateUtil.getInstance().openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(t);
		transaction.commit();
		HibernateUtil.getInstance().closeSession();
		
	}

	@Override
	public List<StoreItem> read() throws SQLException {

		return new ArrayList<>();
	}

	@Override
	public void update(StoreItem t) throws SQLException {
		Session session = HibernateUtil.getInstance().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(t);
		transaction.commit();
		HibernateUtil.getInstance().closeSession();
		
	}

	@Override
	public void delete(StoreItem t) throws SQLException {
		Session session = HibernateUtil.getInstance().openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(t);
		transaction.commit();
		
	}

	@Override
	public ResultSet runCustomSql(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
