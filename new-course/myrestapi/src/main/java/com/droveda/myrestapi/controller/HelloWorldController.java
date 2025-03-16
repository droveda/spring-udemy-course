package com.droveda.myrestapi.controller;

import com.droveda.myrestapi.model.HelloWorldBean;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    private final MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello world!";
    }

    @GetMapping("/hello-bean")
    public ResponseEntity<HelloWorldBean> helloBean() {
        return ResponseEntity.ok(new HelloWorldBean("Hello!!!"));
    }

    @GetMapping("/hello/{name}")
    public ResponseEntity<HelloWorldBean> helloBean2(@PathVariable("name") String name) {
        var message = "Hello " + name;
        return ResponseEntity.ok(new HelloWorldBean(message));
    }

    @GetMapping("/hello-i18n")
    public String helloI18in() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
    }

}
