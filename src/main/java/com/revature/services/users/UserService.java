package com.revature.services.users;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.UserDao;
import com.revature.exceptions.UserDoesNotExistException;
import com.revature.models.users.User;

@Service("UserServiceBean")
public class UserService extends GuestService {
	
    private UserDao userDao;
	
    @Autowired
    public UserService(UserDao userDao) { 
        this.userDao = userDao;
    }
	
    public Optional<User> update(User u) throws UserDoesNotExistException {
        userDao.update(u);
        List<User> users = userDao.read();
        for(User i : users)
            if(i.getUsername().equals(u.getUsername())) return Optional.of(i);
        throw new UserDoesNotExistException();
    }

    public void addItemHistory(LinkedHashMap<Integer, Integer> items) {
    }
}