package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import models.users.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

public class UserDao implements Dao<User> {

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
		User user = session.createQuery(
				"from users where username=:arg",
				User.class

		).setParameter("username",arg)
				.uniqueResult();
		HibernateUtil.getInstance().closeSession();
		return Optional.of(user);

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
