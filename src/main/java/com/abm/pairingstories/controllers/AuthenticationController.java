package com.abm.pairingstories.controllers;

import com.abm.pairingstories.model.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthenticationController {

    @PostMapping("login")
    public String login(Authentication authentication) {
        System.out.println(authentication);
        return "Stories";
    }

}
