package com.leetcode;

import org.junit.Test;

/**
 * Created by admin on 2018/8/8.
 */
public class MoveZeroesTest {
    MoveZeroes t = new MoveZeroes();
    @Test
    public void testMoveZeroes() throws Exception {
        int nums[] = new int[]{0,0,1,1,1,2,2,3,3,0};
        t.moveZeroes(nums);
        //assertEquals(new int[]{1,1,1,2,2,3,3,4}, nums);

        int nums2[] = new int[]{1, 0};
        t.moveZeroes(nums2);
        //assertEquals(new int[]{}, nums2);
        System.out.println("end");
    }
}