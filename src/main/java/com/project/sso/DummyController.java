package com.project.sso;

import com.project.sso.model.RoleType;
import com.project.sso.model.User;
import com.project.sso.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id){
        User user = userRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("해당 사용자는 없습니다.");
        });
        return user;
    }

    @PostMapping("/dummy/join")
    public String join(User user){
        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입이 완료되었습니다";

    }
}
