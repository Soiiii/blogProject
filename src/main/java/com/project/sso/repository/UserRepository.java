package com.project.sso.repository;

import com.project.sso.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Integer>{
    User findByUsernameAndPassword(String username, String password);

}
