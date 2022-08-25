package com.revature.controllers;

import com.revature.exceptions.InvalidCredentialsException;
import com.revature.exceptions.UserAlreadyExistsException;
import com.revature.models.users.User;
import com.revature.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.NestedServletException;

import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/authentication")
@CrossOrigin(origins = "*")

public class AuthenticationController {
    private static final Logger logger = Logger.getLogger(AuthenticationController.class.getName());

    private final  AuthenticationService authenticationService;

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

    @ExceptionHandler({UserAlreadyExistsException.class, NestedServletException.class})
    public ResponseEntity<String> UserAlreadyExistsHandler(UserAlreadyExistsException ex){
        logger.log(Level.INFO,"Username or Email already registered");
        return new ResponseEntity<>("The username or email you are trying to use are already in use", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({InvalidCredentialsException.class})
    public ResponseEntity<String>  InvalidCredentialsHandler(InvalidCredentialsException ex){
        return new ResponseEntity<>("The username or password you are using are incorrect", HttpStatus.FORBIDDEN);
    }
}
 