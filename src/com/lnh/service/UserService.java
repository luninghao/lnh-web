package com.lnh.service;

import com.lnh.dao.UserDao;
import com.lnh.model.User;

public class UserService {
    private UserDao userDAO;
    public UserService(){
        userDAO=new UserDao();
    }

    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    public boolean updateUser(User user){
        return userDAO.updateUser(user);
    }
}
