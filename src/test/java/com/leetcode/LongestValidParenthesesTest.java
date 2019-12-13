package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class LongestValidParenthesesTest {
    LongestValidParentheses t = new LongestValidParentheses();

    @Test
    public void test() {
        int result = t.longestValid("((((()()()((()))))(((((");
        Assert.assertEquals(14, result);
    }
}
