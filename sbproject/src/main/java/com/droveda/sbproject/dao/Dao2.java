package com.droveda.sbproject.dao;

import com.droveda.sbproject.aspect.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class Dao2 {

    @TrackTime
    public String getSomething() {
        return "Dao2";
    }

}
