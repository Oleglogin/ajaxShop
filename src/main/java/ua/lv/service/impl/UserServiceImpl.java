package ua.lv.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lv.dao.UserDAO;
import ua.lv.entity.User;
import ua.lv.service.UserService;

import java.util.List;

/**
 * Created by User on 18.05.2019.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;
    @Override
    public void addUser(User user) {
        userDAO.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userDAO.delete(id);
    }

    @Override
    public User findOne(int id) {
        return userDAO.findOne(id);
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User findByUserName(String username) {
        return userDAO.findByUserName(username);
    }
}
