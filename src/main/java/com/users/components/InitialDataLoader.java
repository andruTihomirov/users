package com.users.components;

import com.users.model.Privilege;
import com.users.model.PrivilegeName;
import com.users.model.RoleName;
import com.users.service.PrivilegeService;
import com.users.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;

/**
 * @author atsikhamirau on 26.02.2019
 */
@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private boolean alreadySetup = false;

    @Autowired
    private PrivilegeService privilegeService;

    @Autowired
    private RoleService roleService;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (alreadySetup) return;
        Privilege readPrivilege = privilegeService.createPrivilegeIfNotFound(PrivilegeName.READ.name());
        Privilege writePrivilege = privilegeService.createPrivilegeIfNotFound(PrivilegeName.WRITE.name());

        roleService.createRoleIfNotFound(RoleName.ROLE_ADMIN.name(), Arrays.asList(readPrivilege, writePrivilege));
        roleService.createRoleIfNotFound(RoleName.ROLE_USER.name(), Arrays.asList(readPrivilege));
    }

}
