package com.users.service;

import com.users.model.Privilege;
import com.users.model.Role;

import java.util.Collection;

/**
 * @author atsikhamirau on 22.02.2019
 */
public interface RoleService {

    Role createRoleIfNotFound(String name, Collection<Privilege> privileges);
}
