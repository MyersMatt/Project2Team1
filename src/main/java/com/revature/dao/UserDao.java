package com.revature.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Logger;

import com.revature.models.users.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.revature.utils.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository("UserDaoBean")
public class UserDao implements Dao<User> {
	private static final Logger logger = Logger.getLogger(UserDao.class.getName());
	private SessionFactory sessionFactory;
	@Autowired
	public UserDao(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void create(User t) throws SQLException {
		Session session = HibernateUtil.getInstance().openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(t);
		transaction.commit();
		HibernateUtil.getInstance().closeSession();
	}

	@Override
	public Optional<User> read(String arg) throws SQLException {
		Session session = HibernateUtil.getInstance().openSession();
		User u = session.createQuery("from User where username=:username" , User.class)
						.setParameter("username",arg)
						.uniqueResult();
		Optional<User> user = Optional.of(u);
		HibernateUtil.getInstance().closeSession();
		return user;

	}

	@Override
	public void update(User t) throws SQLException {
		Session session = HibernateUtil.getInstance().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(t);
		transaction.commit();
		HibernateUtil.getInstance().closeSession();
		
	}

	@Override
	public void delete(User t) throws SQLException {
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
