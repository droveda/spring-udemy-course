package com.droveda.sbproject.dao;

import com.droveda.sbproject.aspect.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {

    @TrackTime
    public String getSomething() {
        return "Dao1";
    }

}
