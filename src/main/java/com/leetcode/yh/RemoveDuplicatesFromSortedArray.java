package com.leetcode.yh;

//26. Remove Duplicates from Sorted Array
/*
Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 */
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

    //大神解法：
    /*
    使用两个指针，一个（i）遍历原来的数组，一个（id）指向新的索引。
    如果nums[i] != nums[i-1]，将新的索引+1，并且nums[id+1] = nums[i]
     */
    public int removeDuplicates(int A[], int n) {
        if(n < 2) return n;
        int id = 1;
        for(int i = 1; i < n; ++i)
            if(A[i] != A[i-1]) A[id++] = A[i];
        return id;
    }

}
