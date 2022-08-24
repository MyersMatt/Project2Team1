package com.revature.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface Dao <T>{
    Logger logger = Logger.getLogger(Dao.class.getName());
    Level level = Level.FINE;
    void create(T t);
    //using optional as to not return null value from read
    List<T> read();
    void update(T t);
    void delete(T t);
    ResultSet runCustomSql(String sql);
}