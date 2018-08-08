package com.leetcode.yh;

/**
 * Created by yuhuan on 2018/8/8.
 * 27. Remove Element
 *
 *
 given an array nums and a value val, remove all instances of that value in-place and return the new length.

 Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        int len = 0;
        for(int i=0; i < nums.length; i++){
            if(nums[i] != val){
                nums[index++] = nums[i];
                len ++;
            }
        }
        return len;
    }
}
