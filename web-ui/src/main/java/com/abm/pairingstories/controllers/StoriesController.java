package com.abm.pairingstories.controllers;

import com.abm.pairingstories.domain.PairingSystem;
import com.abm.pairingstories.exceptions.NoStoryFoundException;
import com.abm.pairingstories.model.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("stories")
public class StoriesController {

    @Autowired
    private PairingSystem pairingSystem;

    @GetMapping
    public ModelAndView stories(@SessionAttribute("auth") Authentication authentication) throws NoStoryFoundException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Stories");
        modelAndView.addObject("story", pairingSystem.getStory(authentication.getExperience().getValue()));
        return modelAndView;
    }

    @PostMapping
    public ModelAndView updateStory(@SessionAttribute("auth") Authentication authentication, @ModelAttribute("reviewer") String reviewer) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Stories");
        modelAndView.addObject("story", pairingSystem.reviewed(reviewer));
        return modelAndView;
    }

}
