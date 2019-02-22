package com.users.service;

import com.users.model.Privilege;

/**
 * @author atsikhamirau on 22.02.2019
 */
public interface PrivilegeService {

    Privilege createPrivilegeIfNotFound(String name);

}
