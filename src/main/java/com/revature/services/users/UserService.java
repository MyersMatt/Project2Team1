package com.revature.services.users;

import com.revature.dao.UserDao;
import com.revature.exceptions.UserAlreadyExistsException;
import com.revature.exceptions.UserDoesNotExistException;
import com.revature.models.items.StoreItem;
import com.revature.models.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service("UserServiceBean")
public class UserService extends GuestService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public Optional<User> update(User u) throws UserDoesNotExistException {
        userDao.update(u);
        List<User> users = userDao.read();
        for (User i : users)
            if (i.getUsername().equals(u.getUsername())) return Optional.of(i);
        throw new UserDoesNotExistException();
    }

    public void addItemHistory(LinkedHashMap<Integer, Integer> items) {

    }

    public Optional<User> getById(Integer i) throws UserDoesNotExistException {
        List<User> users = userDao.read();
        for (User u : users) {
            if (Objects.equals(u.getId(), i)) return Optional.of(u);
        }
        throw new UserAlreadyExistsException();
    }

    public LinkedHashMap<StoreItem, Integer> getItemHistory(Integer id) {
        return new LinkedHashMap<>();
    }
}