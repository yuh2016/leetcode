package com.leetcode;

import java.util.Arrays;

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

