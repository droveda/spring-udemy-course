package com.droveda.controller;

import com.droveda.service.UserValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @Autowired
    private UserValidationService service;

    @RequestMapping(value = "/login-body")
    @ResponseBody
    public String sayHello() {
        return "Hello World!";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String handleLoginGet() {
        return "login-new";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String handleLoginPost(@RequestParam String user, @RequestParam String password, ModelMap model) {

        if (service.validate(user, password)) {
            model.put("user", user);
            model.put("password", password);
            return "welcome";
        } else {
            model.put("errorMessage", "Invalid Credentials!");
            return "login-new";
        }


    }

}
