package com.users.repository;

import com.users.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author atsikhamirau on 22.02.2019
 */
public interface RoleDAO extends JpaRepository<Role, Long> {

    Role findByName(String name);

}
