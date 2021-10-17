package com.droveda.springin5steps.cdi;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class SomeCDIBusiness {

    @Inject
    private SomeCdiDao someCdiDao;

    public SomeCdiDao getSomeCdiDao() {
        return someCdiDao;
    }

    public void setSomeCdiDao(SomeCdiDao someCdiDao) {
        this.someCdiDao = someCdiDao;
    }

    public int findGreatest() {
        int greatest = Integer.MIN_VALUE;
        int[] data = this.someCdiDao.getData();

        for (int value : data) {
            if (value > greatest) {
                greatest = value;
            }
        }

        return greatest;

    }
}
