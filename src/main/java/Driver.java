import dao.UserDao;
import models.users.User;
import org.hibernate.Session;
import services.login.RegistrationService;
import utils.HibernateUtil;

import java.util.Optional;

public class Driver {
    public static void main(String args[]) {
        UserDao userDao = new UserDao();
        Session session = HibernateUtil.getInstance().openSession();
        RegistrationService registrationService = new RegistrationService();
        Optional<User> user = registrationService.register(
                "jon",
                "doe",
                "jdoe@example.com",
                "jdoe",
                "password",
                "123 Example St.",
                "1111-1111-1111"
        );
        if(user.isPresent()) System.out.println(user.get());
    }
}
