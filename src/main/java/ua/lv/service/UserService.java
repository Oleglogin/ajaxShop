package ua.lv.service;

import ua.lv.entity.User;

import java.util.List;

/**
 * Created by User on 18.05.2019.
 */
public interface UserService {

     void addUser(User user);
     void deleteUser(int id);
     User findOne(int id);
     List<User> findAll();
     User findByUserName(String username);

}
