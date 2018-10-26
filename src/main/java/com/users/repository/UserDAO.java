package com.users.repository;

import com.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author atsikhamirau on 23.10.2018
 */
public interface UserDAO extends JpaRepository<User, Long> {}
