package com.project.sso.controller.api;

import com.project.sso.dto.ResponseDto;
import com.project.sso.model.RoleType;
import com.project.sso.model.User;
import com.project.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;

public class UserApiController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;
    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody User user){
        System.out.println("UserApiController: save 호출");
        user.setRole(RoleType.USER);
        userService.join(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @PostMapping("/api/user/login")
    public ResponseDto<Integer> login(@RequestBody User user){
        System.out.println("UserApiContoller: login 호출");
        User principal = userService.login(user);

        if(principal != null){
            session.setAttribute("principal", principal);
        }
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

}
