package com.droveda.myrestapi.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

    @JsonIgnoreProperties("field3")
    public record SomeBean(
            @JsonIgnore
            String field1,
            String field2,
            String field3) {
    }


    public record SomeBean2(
            String field1,
            String field2,
            String field3) {
    }

    @GetMapping("/filtering")
    public SomeBean filtering() {
        return new SomeBean("value1", "value2", "value3");
    }

}
