package com.kang.reserve_3_1_3.service;


import com.kang.reserve_3_1_3.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> index();

    User show(Long id);

    void save(User user);

    void update(Long id, User updatedUser);

    void delete(Long id);
}
