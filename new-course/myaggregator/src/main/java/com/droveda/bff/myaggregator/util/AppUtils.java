package com.droveda.bff.myaggregator.util;

import java.util.concurrent.TimeUnit;

public class AppUtils {

    public static void sleepForSeconds(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
