package com.project.sso.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class webControllerTest {
        @GetMapping("/test/hello")
        public String hello(){
            System.out.println("test");
            return "<h1>hello spring boot</h1>" ;

    }
}
