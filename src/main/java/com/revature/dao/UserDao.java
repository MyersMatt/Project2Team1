package com.revature.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import com.revature.models.users.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository("UserDaoBean")
public class UserDao implements Dao<User> {
	private static final Logger logger = Logger.getLogger(UserDao.class.getName());

	@Autowired
	private final SessionFactory sessionFactory;

	public UserDao(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void create(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public List<User> read() {
		return sessionFactory.getCurrentSession().createQuery("from User", User.class).list();
	}

	@Override
	public void update(User user){
		sessionFactory.getCurrentSession().update(user);
		
	}

	@Override
	public void delete(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}

	@Override
	public ResultSet runCustomSql(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

}
