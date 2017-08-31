package com.leetcode.yh;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	//004
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<nums1.length; i++){
        	list.add(nums1[i]);
        }
        for(int i=0; i<nums2.length; i++){
        	list.add(nums2[i]);
        }
        
        Collections.sort(list);
        
        int center = list.size()/2;
        int left = list.size()%2;
        if(left == 1){
        	return list.get(center);
        }else{
        	return ((double)(list.get(center - 1) + list.get(center)))/2;
        }
    }
	
	//005
	public String longestPalindrome(String s) {
		
		return null;
	}
}
