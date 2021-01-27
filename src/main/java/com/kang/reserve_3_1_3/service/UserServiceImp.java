package com.kang.reserve_3_1_3.service;


import com.kang.reserve_3_1_3.dao.UserDAO;
import com.kang.reserve_3_1_3.models.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UserServiceImp implements UserService {

    private final UserDAO userDao;

    public UserServiceImp(UserDAO userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> index() {
        return userDao.index();
    }

    @Transactional(readOnly = true)
    @Override
    public User show(Long id) {
        return userDao.show(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public void update(Long id, User updatedUser) {
        userDao.update(id,updatedUser);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDao.delete(id);
    }
}
