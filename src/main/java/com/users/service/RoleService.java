package com.users.service;

import com.users.model.Privilege;
import com.users.model.Role;
import com.users.model.RoleName;

import java.util.Collection;

/**
 * @author atsikhamirau on 22.02.2019
 */
public interface RoleService {

    Role createRoleIfNotFound(String name, Collection<Privilege> privileges);

    Role findByName(RoleName name);
}
