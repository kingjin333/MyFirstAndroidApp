package com.hji.myfirstandroidapp.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by 현 on 2016-03-25.
 */
public class CalCTest {

    private CalC mCalc;

    @Before
    public void setUp() throws Exception {
        // 초기화
        mCalc = new CalC();
    }

    @After
    public void tearDown() throws Exception {
        // 끝나고 후 처리.

    }

    @Test
    /**
     *  1.
     */
    public void 합계() throws Exception {
       int result =  mCalc.sum(1, 10);
        Assert.assertEquals(11, result);

        result = mCalc.product(-10, -20);
        Assert.assertEquals(-30, result);


    }

    @Test
    public void 곱셈() throws Exception {
       int result =  mCalc.sum(1, 10);
        Assert.assertEquals(10, result);

        result = mCalc.product(-10, -20);
        Assert.assertEquals(200, result);

    }
}