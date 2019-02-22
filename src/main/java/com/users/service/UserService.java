package com.users.service;

import com.users.dto.UserDto;
import com.users.exceptions.EmailExistsException;
import com.users.model.User;

import java.util.List;

/**
 * @author atsikhamirau on 23.10.2018
 */
public interface UserService {

    List<User> findAll();

    User findById(Long id);

    User save(User user);

    User update(User user);

    void deleteById(Long id);

    User registerNewUserAccount(UserDto accountDto) throws EmailExistsException;
}
