package com.droveda.springin5steps.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BinarySearchImpl {

    private final static Logger LOGGER = LoggerFactory.getLogger(BinarySearchImpl.class);

    @Autowired
    @Qualifier("quickSort")
    private SortAlgo sortAlgo;

    public int binarySearch(int[] numbers, int numberToSearchFor) {
        int[] sorted = sortAlgo.sort(numbers);
        System.out.println(sortAlgo);

        //search the array using binary search

        return 3;
    }

    @PostConstruct
    public void postConstruct() {
        LOGGER.info("post construct");
    }

    @PreDestroy
    public void preDestroy() {
        LOGGER.info("pre destroy");
    }

}
