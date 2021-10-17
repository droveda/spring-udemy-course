package com.droveda.springin5steps.cdi;

import javax.inject.Named;

@Named
public class SomeCdiDao {

    public int[] getData() {
        return new int[]{
                5, 89, 100
        };
    }

}
