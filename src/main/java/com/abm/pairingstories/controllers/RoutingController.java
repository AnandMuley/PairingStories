package com.abm.pairingstories.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @GetMapping(value = "stories")
    public String stories() {
        return "Stories";
    }

}