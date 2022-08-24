package com.revature;

import com.revature.controllers.AuthenticationController;
import com.revature.models.users.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("WEB-INF/beans.xml");
        AuthenticationController authenticationController = applicationContext.getBean("authenticationController", AuthenticationController.class);

        User u = new User(
                "Steve",
                "Rogers",
                "srogers@example.com",
                "srogers",
                "password",
                "123 Example St.",
                "1111-1111-1111"
        );
        User user = authenticationController.register(u);
        System.out.println(user.toString());

        u = new User(
                "Bruce",
                "Banner",
                "bbanner@example.com",
                "bbanner",
                "password",
                "123 Example St.",
                "1111-1111-1111"
        );
        user = authenticationController.register(u);
        System.out.println(user.toString());
        u = new User(
                "Tony",
                "Stark",
                "tstark@example.com",
                "tstark",
                "password",
                "123 Example St.",
                "1111-1111-1111"
        );
        user = authenticationController.register(u);
        System.out.println(user.toString());
        
    }

}

