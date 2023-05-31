package com.project.sso.controller.api;

import com.project.sso.dto.ResponseDto;
import com.project.sso.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UserApiController {

    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody User user){
        System.out.println("UserApiController: save 호출");
        return new ResponseDto<Integer>(HttpStatus.OK, 1);
    }
}
