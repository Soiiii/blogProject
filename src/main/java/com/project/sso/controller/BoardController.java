package com.project.sso.controller;

import com.project.sso.config.auth.PrincipalDetail;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;

public class BoardController {

    @GetMapping({"","/"})
    public String index(@AuthenticationPrincipal PrincipalDetail principal){
        System.out.println("로그인 사용자 아이디:" + principal.getUsername());
        return "index";
    }
}
