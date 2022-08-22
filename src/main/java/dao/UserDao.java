package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import models.users.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UserDao implements Dao<User> {
	private static final Logger logger = Logger.getLogger(UserDao.class.getName());
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
		Optional<User> user = Optional.empty();
		Session session = HibernateUtil.getInstance().openSession();
		User u = session.createQuery("from User where username=:username" , User.class)
						.setParameter("username",arg)
						.uniqueResult();
		user = Optional.of(u);
		HibernateUtil.getInstance().closeSession();
		return user;

	}

	@Override
	public void update(User t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultSet runCustomSql(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
