package com.project.sso.repository;

import com.project.sso.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Integer>{
    //Select * FROM user WHERE username=1?;
    Optional<User> findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);

}
