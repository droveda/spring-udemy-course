package com.droveda.componentscan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ComponentDAO {

    @Autowired
    private ComponentJDBCConnection jdbccOnnection;

    public ComponentJDBCConnection getJdbccOnnection() {
        return jdbccOnnection;
    }

    public void setJdbccOnnection(ComponentJDBCConnection jdbccOnnection) {
        this.jdbccOnnection = jdbccOnnection;
    }
}
