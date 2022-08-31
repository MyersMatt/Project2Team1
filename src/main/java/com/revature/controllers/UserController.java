package com.revature.controllers;

import com.revature.exceptions.UserDoesNotExistException;
import com.revature.models.users.User;
import com.revature.services.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.NestedServletException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;


@Controller
@RequestMapping("/user")
@CrossOrigin(origins = "*") 

public class UserController {
 
    private static final Logger logger = Logger.getLogger(UserController.class.getName());

    private final  UserService userService;
  
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PatchMapping ("/updateUser")
    public @ResponseBody User update(@RequestBody User u) {
        Optional<User> user  = userService.update(u);
        return user.orElse(null);
    }

    @ExceptionHandler({UserDoesNotExistException.class, NestedServletException.class})
    public ResponseEntity<String> UserDoesNotExistHandler(UserDoesNotExistException ex){
        logger.log(Level.INFO,"Username is not registered");
        return new ResponseEntity<>("The username you entered is not in use", HttpStatus.BAD_REQUEST);
    }
	
}

 
 
  


 





