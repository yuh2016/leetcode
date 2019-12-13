package com.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by admin on 2018/8/13.
 */
public class DivideTwoIntegersTest {
    DivideTwoIntegers t = new DivideTwoIntegers();

    @Test
    public void testDivide() throws Exception {
        int result = t.divide(10, 3);
        assertEquals(3, result);

        int result2 = t.divide(7, -3);
        assertEquals(-2, result2);

        int result3 = t.divide(0, 3);
        assertEquals(0, result3);

        int result4 = t.divide(1, 1);
        assertEquals(1, result4);

        int result5 = t.divide(-2147483648, -1);
        assertEquals(2147483647, result5);
    }
}