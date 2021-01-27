package com.kang.reserve_3_1_3.dao;


import com.kang.reserve_3_1_3.models.User;

import java.util.List;

public interface UserDAO {

    List<User> index();

    User show(Long id);

    void save(User person);

    void update(Long id, User updatedPerson);

    void delete(Long id);

    User loadUserByUserName(String username);
}
