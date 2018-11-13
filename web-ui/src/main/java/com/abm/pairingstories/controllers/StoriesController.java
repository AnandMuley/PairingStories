package com.abm.pairingstories.controllers;

import com.abm.pairingstories.exceptions.NoStoryFoundException;
import com.abm.pairingstories.model.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("stories")
public class StoriesController {


    @ExceptionHandler(NoStoryFoundException.class)
    public ModelAndView noStoriesSetup(Exception ex) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("ErrorPage");
        mav.addObject("message", ex.getMessage());
        return mav;
    }

    @GetMapping
    public ModelAndView stories(@SessionAttribute("auth") Authentication authentication) throws NoStoryFoundException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Stories");
        modelAndView.addObject("story", authentication.getPairingSystem().getStory(authentication.getExperience().getValue()));
        return modelAndView;
    }

    @PostMapping
    public ModelAndView updateStory(@SessionAttribute("auth") Authentication authentication, @ModelAttribute("reviewer") String reviewer) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Stories");
        modelAndView.addObject("story", authentication.getPairingSystem().reviewed(reviewer));
        return modelAndView;
    }

}
