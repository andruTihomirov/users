package com.users.service;

import com.users.dto.UserDto;
import com.users.exceptions.EmailExistsException;
import com.users.model.User;
import com.users.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author atsikhamirau on 23.10.2018
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User findById(Long id) {
        return userDAO.findById(id).orElse(null);
    }

    public User save(User user) {
        return userDAO.save(user);
    }

    @Override
    public User update(User user) {
        if (user.getId() == null) {
            throw new IllegalArgumentException("User id can't be null.");
        }
        return userDAO.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userDAO.deleteById(id);
    }

    @Override
    @Transactional
    public User registerNewUserAccount(UserDto accountDto) throws EmailExistsException {
        if (emailExists(accountDto.getEmail())) {
            throw new EmailExistsException(
                    "There is an account with that email address: " + accountDto.getEmail());
        }
        User user = new User();
        user.setFirstName(accountDto.getFirstName());
        user.setLastName(accountDto.getLastName());
        user.setPassword(accountDto.getPassword());
        user.setEmail(accountDto.getEmail());
        user.setUsername(accountDto.getEmail());
        // user.setRoles(Arrays.asList("ROLE_USER"));
        return userDAO.save(user);
    }

    private boolean emailExists(String email) {
        User user = userDAO.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }
}
