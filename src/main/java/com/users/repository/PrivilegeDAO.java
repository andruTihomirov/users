package com.users.repository;

import com.users.model.Privilege;
import com.users.model.PrivilegeName;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author atsikhamirau on 22.02.2019
 */
public interface PrivilegeDAO extends JpaRepository<Privilege, Long> {

    Privilege findByName(PrivilegeName name);

}
