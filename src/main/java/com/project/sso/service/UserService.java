package com.project.sso.service;

import com.project.sso.model.User;
import com.project.sso.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void join(User user){
        userRepository.save(user);
    }
}
