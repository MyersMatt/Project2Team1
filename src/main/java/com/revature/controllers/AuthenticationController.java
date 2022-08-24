package com.revature.controllers;

import com.revature.models.users.User;
import com.revature.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Optional;

@Controller
@RequestMapping("/authentication")
@CrossOrigin(origins = "*")
public class AuthenticationController {

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
}
