package com.leetcode.yh;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by admin on 2018/8/10.
 */
public class ImplementStrStrTest {
    ImplementStrStr t = new ImplementStrStr();

    @Test
    public void testStrStr() throws Exception {
        int result = t.strStr("abcabcabc", "bca");
        assertEquals(1, result);

        int result2 = t.strStr("", "");
        assertEquals(0, result2);

        int result3 = t.strStr("abcabcabc", "aaa");
        assertEquals(-1, result3);

        int result4 = t.strStr("abciiiijkmndf", "ijkmn");
        assertEquals(6, result4);

        int result5 = t.strStr("aaaa", "aaaaa");
        assertEquals(-1, result5);
    }
}