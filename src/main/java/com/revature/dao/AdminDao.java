package com.revature.dao;

import com.revature.models.users.Admin;

import java.sql.ResultSet;
import java.util.List;

public class AdminDao implements Dao<Admin>{
    @Override
    public void create(Admin admin) {

    }

    @Override
    public List<Admin> read() {
        return null;
    }

    @Override
    public void update(Admin admin) {

    }

    @Override
    public void delete(Admin admin) {

    }

    @Override
    public ResultSet runCustomSql(String sql) {
        return null;
    }
}
