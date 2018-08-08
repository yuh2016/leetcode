package com.leetcode.yh;

//26. Remove Duplicates from Sorted Array
public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
		if(nums.length == 0) return 0;
		if(nums.length == 1) return 1;
		int i = 1;
		int length = nums.length;
		int tmp = nums[0];
		int count = 0;
		while(i < length){
			if(nums[i] == tmp){
				count ++;
                i++;
			} else {
                tmp = nums[i];
                if (count > 0){
                    nums = remove(nums, i, count);
                    length = length - count;
                    i = i - count  + 1;
                    count = 0;
                }else {
                    i++;
                }
			}

		}

        if(count > 0){
            nums = remove(nums, length - 1, count);
            length = length - count;
        }
		
		return length;
	}
	
	public int[] remove(int[] nums, int end, int len){
		for(int i = end - len; i < nums.length - len; i++){
			nums[i] = nums[i + len];
		}
        for(int i = nums.length - len; i < nums.length; i++) {
            nums[i] = 0;
        }
		return nums;
	}
}
