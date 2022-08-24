package com.revature;

import com.revature.controllers.AuthenticationController;
import com.revature.models.users.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Optional;

public class Driver {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        AuthenticationController authenticationController = applicationContext.getBean("authenticationController", AuthenticationController.class);
        Optional<User> user = authenticationController.register(
                "Steve",
                "Rogers",
                "srogers@example.com",
                "srogers",
                "password",
                "123 Example St.",
                "1111-1111-1111"
        );
        user.ifPresent(System.out::println);

        user = authenticationController.register(
                "Bruce",
                "Banner",
                "bbanner@example.com",
                "bbanner",
                "password",
                "123 Example St.",
                "1111-1111-1111"
        );
        user.ifPresent(System.out::println);

        user = authenticationController.register(
                "Tony",
                "Stark",
                "tstark@example.com",
                "tstark",
                "password",
                "123 Example St.",
                "1111-1111-1111"
        );
        user.ifPresent(System.out::println);
        
    }

}

