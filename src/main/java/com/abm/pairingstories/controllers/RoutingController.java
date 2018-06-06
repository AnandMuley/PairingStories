package com.abm.pairingstories.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class RoutingController {

    @GetMapping
    public String index() {
        return "Index";
    }

    @GetMapping(value = "stories")
    public String stories(){
        return "Stories";
    }

}
