package com.project.sso.controller.api;

import com.project.sso.dto.ResponseDto;
import com.project.sso.model.RoleType;
import com.project.sso.model.User;
import com.project.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    @Autowired
    private UserService userService;

    @PostMapping("/auth/joinProc")
    public ResponseDto<Integer> save(@RequestBody User user){
        System.out.println("UserApiController: save 호출");
        user.setRole(RoleType.USER);
        userService.join(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @PutMapping("/user")
    public ResponseDto<Integer> update(@RequestBody User user){
        userService.userEdit(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}
