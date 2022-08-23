package com.revature.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface Dao <T>{
    Logger logger = Logger.getLogger(Dao.class.getName());
    Level level = Level.FINE;
    void create(T t) throws SQLException;
    //using optional as to not return null value from read
    Optional<T> read(String arg) throws SQLException;
    void update(T t) throws SQLException;
    void delete(T t) throws SQLException;
    ResultSet runCustomSql(String sql) throws SQLException;
}