package com.revature.dao;

import com.revature.models.users.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Logger;

@Transactional
@Repository("UserDaoBean")
public class UserDao implements Dao<User> {
	private static final Logger logger = Logger.getLogger(UserDao.class.getName());


	private final SessionFactory sessionFactory;

	@Autowired
	public UserDao(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void create(User user) throws DataIntegrityViolationException{
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
