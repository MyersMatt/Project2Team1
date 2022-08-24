package com.revature.services;

import com.revature.dao.UserDao;
import com.revature.models.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service("AuthenticationServiceBean")
public class AuthenticationService {
    private static final Logger logger = Logger.getLogger(AuthenticationService.class.getName());

    @Autowired
    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void login(String username, String password) {
    }

    public Optional<User> register(String firstName,
                                   String lastName,
                                   String email,
                                   String userName,
                                   String password,
                                   String shippingAddress,
                                   String paymentInfo) {
        try {
            User user = new User(firstName, lastName, email, userName, password, shippingAddress, paymentInfo);
            userDao.create(user);
            List<User> users = userDao.read();
            for(User u : users)
                if(u.getUsername().equals(userName)) return Optional.of(u);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error creating new user");
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
