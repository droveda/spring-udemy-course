package com.droveda.myfirstwebbapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

    private static final Logger log = LoggerFactory.getLogger(WelcomeController.class);


    //    @RequestMapping("/login")
//    public String loginPage(@RequestParam("name") String name, ModelMap model) {
//        log.debug("name {}", name);
//        model.put("name", name);
//        return "login";
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String gotoWelcomePage(ModelMap model) {
        model.put("name", getLoggedInUsername());
        return "welcome";
    }

    private String getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
//        model.put("name", name);
//        model.put("password", password);
//
//        if (authenticationService.authenticate(name, password)) {
//            return "welcome";
//        }
//
//        model.put("errorMessage", "Invalid Credentials! Please try again.");
//        return "login";
//    }

}
