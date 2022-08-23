package com.revature.services.login;

import com.revature.dao.UserDao;
import com.revature.models.users.User;

import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistrationService {
    private static final Logger logger = Logger.getLogger(RegistrationService.class.getName());
    private final UserDao userDao;
    public RegistrationService() {this.userDao = new UserDao();}
    public Optional<User> register(String firstName,
                                   String lastName,
                                   String email,
                                   String userName,
                                   String password,
                                   String shippingAddress,
                                   String paymentInfo){
        try{
            User user = new User(firstName,lastName,email,userName,password,shippingAddress,paymentInfo);
            userDao.create(user);
            return userDao.read(userName);
        }catch (SQLException e){
            logger.log(Level.SEVERE,"Error creating new user");
            e.printStackTrace();
        }
        return Optional.empty();
    }
	
}
