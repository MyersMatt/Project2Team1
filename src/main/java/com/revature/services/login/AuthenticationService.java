package com.revature.services.login;

import com.revature.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AuthenticationServiceBean")
public class AuthenticationService {
    @Autowired
    private UserDao userDao;
    @Autowired
    public AuthenticationService(UserDao userDao){
        this.userDao=userDao;
    }
}
