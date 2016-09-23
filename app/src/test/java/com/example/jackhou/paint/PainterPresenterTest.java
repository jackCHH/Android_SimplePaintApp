package com.example.jackhou.paint;

import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

public class PainterPresenterTest {


    @Mock
    PainterPresenter pp = new PainterPresenter();

    @Test
    public void testCalculate1() throws Exception {
        float answer = pp.calculate(15,22,21,14);
        assertEquals(10f,answer, 0.000);
    }

    @Test
    public void testCalculate2() throws Exception {
        float answer = pp.calculate(3,4,0,0);
        assertEquals(5f,answer, 0.000);
    }

    @Test
    public void testCalculate3() throws Exception {
        float answer = pp.calculate(60,90,120,181);
        assertEquals(109f,answer, 0.000);
    }

}