package com.leetcode.yh;

import java.util.Arrays;

/**
 * Created by yuhuan on 2018/8/20.
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums.length == 1) return;
        int right = nums.length - 1;
        int left = nums.length - 2;

        while(left >= 0 && right > left){
            if(nums[left] < nums[right]){
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                return;
            }else{
                left --;
                right --;
            }
        }

        Arrays.sort(nums);
    }
}

