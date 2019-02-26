package com.users.service;

import com.users.model.Privilege;
import com.users.model.Role;
import com.users.model.RoleName;
import com.users.repository.RoleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author atsikhamirau on 22.02.2019
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDao;

    @Override
    public Role findByName(RoleName name) {
        return roleDao.findByName(name);
    }

    @Override
    public Role createRoleIfNotFound(String name, Collection<Privilege> privileges) {
        Role role = roleDao.findByName(RoleName.valueOf(name));
        if (role == null) {
            role = new Role(name);
            role.setPrivileges(privileges);
            roleDao.save(role);
        }
        return role;
    }
}
