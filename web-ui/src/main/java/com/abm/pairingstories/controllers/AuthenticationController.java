package com.abm.pairingstories.controllers;

import com.abm.pairingstories.domain.PairingSystem;
import com.abm.pairingstories.model.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("auth")
public class AuthenticationController {

    @ModelAttribute("auth")
    public Authentication getAuth() {
        return new Authentication();
    }

    @PostMapping("login")
    public String login(@ModelAttribute("auth") Authentication authentication) {
        authentication.setPairingSystem(new PairingSystem());
        return "redirect:stories";
    }

    @GetMapping("logout")
    public ModelAndView logout(ModelAndView modelAndView, SessionStatus sessionStatus, @ModelAttribute("auth") Authentication authentication) {
        sessionStatus.setComplete();
        authentication.removePairingSystem();
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

}
