package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import models.users.User;

public class UserDao implements Dao<User> {

	@Override
	public void create(User t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<User> read(String arg) throws SQLException {
		// TODO Auto-generated method stub
		return Optional.empty();
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
