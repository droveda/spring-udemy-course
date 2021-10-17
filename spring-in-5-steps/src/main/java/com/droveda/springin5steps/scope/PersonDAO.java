package com.droveda.springin5steps.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDAO {

    @Autowired
    private JDBCConnection jdbccOnnection;

    public JDBCConnection getJdbccOnnection() {
        return jdbccOnnection;
    }

    public void setJdbccOnnection(JDBCConnection jdbccOnnection) {
        this.jdbccOnnection = jdbccOnnection;
    }
}
