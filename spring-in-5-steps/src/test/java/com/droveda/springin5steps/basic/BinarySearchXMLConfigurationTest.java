package com.droveda.springin5steps.basic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

//load the context
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "/testContext.xml")
public class BinarySearchXMLConfigurationTest {

    @Autowired
    BinarySearchImpl binarySearch;

    @Test
    public void testBasicScenario() {
        int result = binarySearch.binarySearch(new int[]{}, 3);
        assertEquals(3, result);
    }


}
