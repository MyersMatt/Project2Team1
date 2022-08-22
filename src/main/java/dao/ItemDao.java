package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;

import models.items.StoreItem;
import utils.HibernateUtil;

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
	public Optional<StoreItem> read(String arg) throws SQLException {
		Session session = HibernateUtil.getInstance().openSession();
		StoreItem u = session.createQuery("from StoreItem where id=:id" , StoreItem.class)
						.setParameter("id",Integer.parseInt(arg))
						.uniqueResult();
		Optional<StoreItem> item = Optional.of(u);
		HibernateUtil.getInstance().closeSession();
		return item;
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
