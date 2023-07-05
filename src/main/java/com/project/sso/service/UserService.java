package com.project.sso.service;

import com.project.sso.model.RoleType;
import com.project.sso.model.User;
import com.project.sso.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private BCryptPasswordEncoder encoder;

    @Transactional
    public void join(User user){
        String rawPassword = user.getPassword();
//        String encPassword = encoder.encode(rawPassword);
        user.setPassword(rawPassword);
        user.setRole((RoleType.USER));
        userRepository.save(user);
    }

    @Transactional
    public void userUpdate(User user){
        User persistance = userRepository.findById(user.getId()).orElseThrow(()->{
            return new IllegalArgumentException("회원 찾기 실패");
        });
        String rawPassword = user.getPassword();
//        String encPassword = encoder.encode(rawPassword);
        persistance.setPassword(rawPassword);
        persistance.setEmail(user.getEmail());

    }
}
