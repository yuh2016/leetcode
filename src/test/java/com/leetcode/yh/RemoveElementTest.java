package com.leetcode.yh;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by admin on 2018/8/8.
 */
public class RemoveElementTest {
    RemoveElement t = new RemoveElement();

    @Test
    public void testRemoveElement() throws Exception {
        int nums[] = new int[]{0,0,1,1,1,2,2,3,3,4};
        int result = t.removeElement(nums, 2);
        assertEquals(8, result);

        int nums2[] = new int[]{1, 1};
        int result2 = t.removeElement(nums2, 1);
        assertEquals(0, result2);
    }
}