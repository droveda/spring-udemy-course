package com.droveda.sbproject.service;

import com.droveda.sbproject.dao.Dao1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {

    @Autowired
    private Dao1 dao1;

    public String calculateSomething() {
        return dao1.getSomething();
    }

}
