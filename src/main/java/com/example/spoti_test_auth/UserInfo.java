package com.example.spoti_test_auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserInfo {

    @GetMapping("/user")
    public Principal getuser (Principal principal){
        System.out.println("User");
        return principal;
    }

    @GetMapping("/hello")
    public Principal get(Principal principal) {
        return principal;
    }


}
