import dao.UserDao;
import models.users.User;
import org.hibernate.Session;
import services.login.RegistrationService;
import utils.HibernateUtil;

import java.util.Optional;

public class Driver {
    public static void main(String[] args) {
        RegistrationService registrationService = new RegistrationService();
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

