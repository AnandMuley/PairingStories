package com.abm.pairingstories.controllers;

import com.abm.pairingstories.domain.PairingSystem;
import com.abm.pairingstories.domain.exceptions.NoStoryFoundException;
import com.abm.pairingstories.model.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class RoutingController {

    @Autowired
    private PairingSystem pairingSystem;

    @GetMapping(value = "index")
    public String index() {
        return "Index";
    }

    @GetMapping
    public String login() {
        return "Login";
    }

    @GetMapping(value = "stories")
    public ModelAndView stories(@SessionAttribute("auth") Authentication authentication) throws NoStoryFoundException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Stories");
        modelAndView.addObject("story", pairingSystem.getStory(authentication.getExperience().getValue()));
        return modelAndView;
    }

}
