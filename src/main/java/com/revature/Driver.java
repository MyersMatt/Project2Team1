package com.revature;

import com.revature.dao.UserDao;
import com.revature.models.users.User;
import com.revature.services.login.RegistrationService;
import com.revature.utils.HibernateUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Optional;

public class Driver {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        RegistrationService registrationService = applicationContext.getBean("RegistrationServiceBean", RegistrationService.class);
        Optional<User> user = registrationService.register(
                "Steve",
                "Rogers",
                "srogers@example.com",
                "srogers",
                "password",
                "123 Example St.",
                "1111-1111-1111"
        );
        user.ifPresent(System.out::println);

        user = registrationService.register(
                "Bruce",
                "Banner",
                "bbanner@example.com",
                "bbanner",
                "password",
                "123 Example St.",
                "1111-1111-1111"
        );
        user.ifPresent(System.out::println);

        user = registrationService.register(
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

