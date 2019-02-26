package com.users.service;

import com.users.model.Privilege;
import com.users.model.PrivilegeName;
import com.users.repository.PrivilegeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author atsikhamirau on 22.02.2019
 */
@Service
public class PrivilegeServiceImpl implements PrivilegeService {

    @Autowired
    private PrivilegeDAO privilegeDao;

    @Override
    public Privilege createPrivilegeIfNotFound(String name) {
        Privilege privilege = privilegeDao.findByName(PrivilegeName.valueOf(name));
        if (privilege == null) {
            privilege = new Privilege(name);
            privilegeDao.save(privilege);
        }
        return privilege;
    }
}
