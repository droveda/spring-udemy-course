package com.droveda.sbproject.service;

import com.droveda.sbproject.dao.Dao2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessService2 {

    @Autowired
    private Dao2 dao2;

    public String calculateSomething() {
        return dao2.getSomething();
    }

}
