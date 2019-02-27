package com.leetcode.yh;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by admin on 2018/8/20.
 */
public class NextPermutationTest {
    NextPermutation t = new NextPermutation();
    @Test
    public void testNextPermutation() throws Exception {
        int[] nums = new int[]{1, 2, 3};
        t.nextPermutation(nums);
        printNum(nums);
        assertArrayEquals(new int[]{1, 3, 2}, nums);

        int[] nums2 = new int[]{3, 2, 1};
        t.nextPermutation(nums2);
        printNum(nums2);
        assertArrayEquals(new int[]{1, 2, 3}, nums2);

        int[] nums3 = new int[]{1, 1, 5};
        t.nextPermutation(nums3);
        printNum(nums3);
        assertArrayEquals(new int[]{1, 5, 1}, nums3);

        int[] nums4 = new int[]{1, 3, 2};
        t.nextPermutation(nums4);
        printNum(nums4);
        assertArrayEquals(new int[]{2, 1, 3}, nums4);
    }

    public void printNum(int[] nums){
        for(int i=0; i<nums.length;i ++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}