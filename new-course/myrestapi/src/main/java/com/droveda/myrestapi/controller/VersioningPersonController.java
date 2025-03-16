package com.droveda.myrestapi.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    public record Person(@JsonProperty("complete_name") String name) {
    }

    public record PersonV2(Name name) {
    }

    public record Name(String firstName, String lastName) {
    }

    @GetMapping("/v1/person")
    public Person getPerson() {
        return new Person("Bob Smith");
    }


    @GetMapping("/v2/person")
    public PersonV2 getPersonV2() {
        return new PersonV2(new Name("Bob", "Smith"));
    }


    @GetMapping(path = "/person", params = "version=1")
    public Person getPersonParam1() {
        return new Person("Bob Smith");
    }


    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getPersonV2Param2() {
        return new PersonV2(new Name("Bob", "Smith"));
    }


    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public Person getPersonHeader1() {
        return new Person("Bob Smith");
    }


    @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getPersonHeader2() {
        return new PersonV2(new Name("Bob", "Smith"));
    }


    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public Person getPersonAcceptHeader1() {
        return new Person("Bob Smith");
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getPersonAcceptHeader2() {
        return new PersonV2(new Name("Bob", "Smith"));
    }

}
