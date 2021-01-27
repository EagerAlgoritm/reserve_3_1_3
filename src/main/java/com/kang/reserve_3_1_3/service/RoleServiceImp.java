package com.kang.reserve_3_1_3.service;


import com.kang.reserve_3_1_3.dao.RoleDao;
import com.kang.reserve_3_1_3.models.Role;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class RoleServiceImp implements RoleService{

    private final RoleDao roleDao;

    public RoleServiceImp(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }
}

