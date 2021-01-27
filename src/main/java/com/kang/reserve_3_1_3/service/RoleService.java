package com.kang.reserve_3_1_3.service;


import com.kang.reserve_3_1_3.models.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {

    List<Role> getAllRoles();
}
