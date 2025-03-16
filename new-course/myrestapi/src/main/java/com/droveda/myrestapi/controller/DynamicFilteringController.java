package com.droveda.myrestapi.controller;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DynamicFilteringController {


    @JsonFilter("SomeBeanFilter")
    public record SomeBean2(
            String field1,
            String field2,
            String field3) {
    }

    @GetMapping("/filtering-dynamic")
    public MappingJacksonValue filtering() {
        var bean = new SomeBean2("value1", "value2", "value3");

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(bean);
        FilterProvider filter = new SimpleFilterProvider().addFilter("SomeBeanFilter",
                SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3"));

        mappingJacksonValue.setFilters(filter);

        return mappingJacksonValue;
    }

}
