package com.leetcode.yh;

/**
 * Created on 2018/8/13.
 *
 *
 Given two integers tmpend and tmpsor, divide two integers without using multiplication, division and mod operator.

 Return the quotient after dividing tmpend by tmpsor.

 The integer division should truncate toward zero.

 越界返回2的31次方-1
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        //正负问题
        //越界问题
        boolean flag = true;
        if(dividend == 0) return 0;
        long tmpend = dividend;
        long tmpsor = divisor;
        if(tmpend > Integer.MAX_VALUE || tmpend < Integer.MIN_VALUE) return Integer.MAX_VALUE;
        if((tmpend > 0 && tmpsor < 0) || (tmpend < 0 && tmpsor > 0)) flag = false;

        if(tmpend < 0) tmpend = -tmpend;
        if(tmpsor < 0) tmpsor = -tmpsor;

        long result = 0;
        while(tmpend >= tmpsor){
            tmpend -= tmpsor;
            result ++;
        }

        if(!flag) result = -result;
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return Integer.MAX_VALUE;

        return (int)result;
    }
}
