package com.revature.controllers;

import com.revature.services.login.AuthenticationService;
import com.revature.services.login.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authentication")
@CrossOrigin(origins = "*")
public class AuthenticationController {
    private AuthenticationService authenticationService;
    private RegistrationService registrationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService, RegistrationService registrationService){
        this.authenticationService = authenticationService;
        this.registrationService = registrationService;
    }

}
