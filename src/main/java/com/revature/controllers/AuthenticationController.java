package com.revature.controllers;

import com.revature.models.users.User;
import com.revature.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class AuthenticationController {

    private AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
    }

    public Optional<User> register(String firstName,
                                   String lastName,
                                   String email,
                                   String userName,
                                   String password,
                                   String shippingAddress,
                                   String paymentInfo) {
        return authenticationService.register(firstName, lastName, email, userName, password, shippingAddress, paymentInfo);
    }

    public Optional<User> login(String username, String password){
        authenticationService.login(username,password);
        return Optional.empty();
    }

    @Autowired
    public AuthenticationService getAuthenticationService() {
        return authenticationService;
    }

    @Autowired
    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
}
