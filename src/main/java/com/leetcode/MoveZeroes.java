package com.leetcode;

/**
 * Created by yuhuan on 2018/8/8.
 283. Move Zeroes
 Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int start = 0;
        int len = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                nums[start++] = nums[i];
                len ++;
            }
        }

        for(int i = nums.length - 1; i >= len; i--){
            nums[i] = 0;
        }

        //第二个循环可以换种方法，不需要len这个变量。
        while(start<nums.length){
            nums[start++]=0;
        }
    }
}
