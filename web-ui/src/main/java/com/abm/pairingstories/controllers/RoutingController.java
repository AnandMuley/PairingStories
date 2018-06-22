package com.abm.pairingstories.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RoutingController {

    @GetMapping(value = "index")
    public String index() {
        return "Index";
    }

    @GetMapping
    public String login() {
        return "Login";
    }

}
