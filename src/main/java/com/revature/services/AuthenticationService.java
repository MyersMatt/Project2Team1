package com.revature.services;

import com.revature.dao.UserDao;
import com.revature.exceptions.InvalidCredentialsException;
import com.revature.exceptions.UserAlreadyExistsException;
import com.revature.models.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service("AuthenticationServiceBean")
public class AuthenticationService {
    private static final Logger logger = Logger.getLogger(AuthenticationService.class.getName());


    private UserDao userDao;

    @Autowired
    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public Optional<User> login(String username, String password) throws InvalidCredentialsException {
        List<User> users = userDao.read();
        for(User u : users){
            if(u.getUsername().equals(username) && u.getPassword().equals(password)) return Optional.of(u);
            else throw new InvalidCredentialsException(username,password);
        }
        return Optional.empty();
    }

    public Optional<User> register(User u) throws UserAlreadyExistsException {
        try {
            userDao.create(u);
        }catch (DataIntegrityViolationException e){
            throw new UserAlreadyExistsException();
        }
        List<User> users = userDao.read();
        for(User i : users)
            if(i.getUsername().equals(u.getUsername())) return Optional.of(i);
        return Optional.empty();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

}
