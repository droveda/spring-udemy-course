package com.droveda.springin5steps.cdi;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SomeCDIBusinessTest {

    @InjectMocks
    private SomeCDIBusiness business;

    @Mock
    SomeCdiDao daoMock;

    @Test
    public void testBasicScenario() {
        when(daoMock.getData()).thenReturn(new int[]{200, 1000, 500});
        assertEquals(1000, business.findGreatest());
    }

    @Test
    public void testBasicScenario2() {
        when(daoMock.getData()).thenReturn(new int[]{1001, 1000, 500});
        assertEquals(1001, business.findGreatest());
    }

}
