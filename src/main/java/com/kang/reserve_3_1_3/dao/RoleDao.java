package com.kang.reserve_3_1_3.dao;


import com.kang.reserve_3_1_3.models.Role;

import java.util.List;

public interface RoleDao {

    List<Role> getAllRoles();

    Role getRole(long id);
}
