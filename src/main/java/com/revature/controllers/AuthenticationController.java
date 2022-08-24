package com.revature.controllers;

import com.revature.models.users.User;
import com.revature.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.ConstraintViolationException;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/authentication")
@CrossOrigin(origins = "*")
public class AuthenticationController {
    private static final Logger logger = Logger.getLogger(AuthenticationController.class.getName());

    private AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
    }

    @PostMapping ("/register")
    public @ResponseBody User register(@RequestBody User u) {
        Optional<User> user  = authenticationService.register(u);
        return user.orElse(null);
    }

    @PostMapping("/login")
    public @ResponseBody User login(@RequestBody
                                    LinkedHashMap<String,String> body){
        Optional<User> user = authenticationService.login(body.get("username"),body.get("password"));
        return user.orElse(null);
    }

    @Autowired
    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public void handleException(ConstraintViolationException ex){
        logger.log(Level.INFO,"Username or Email already registered");
    }
}
