package com.droveda.myfirstwebbapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        return "Hello! What are you learning today?";
    }

    @RequestMapping("/hello-html")
    @ResponseBody
    public String helloHtml() {
        return """
                <html>
                    <head>
                        <title>Hello</title>
                    </head>
                    <body>
                        <h1>Hello! What are you learning today?</h1>
                    </body>
                """;
    }

    @RequestMapping("/hello-html2")
    public String helloHtml2() {
        return "hello";
    }

    @RequestMapping("/say-hello-jsp")
    public String sayHelloJSP() {
        return "sayHello";
    }

}
