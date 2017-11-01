package com.leetcode.yh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
	// 004 Median of Two Sorted Arrays
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums1.length; i++) {
			list.add(nums1[i]);
		}
		for (int i = 0; i < nums2.length; i++) {
			list.add(nums2[i]);
		}

		Collections.sort(list);

		int center = list.size() / 2;
		int left = list.size() % 2;
		if (left == 1) {
			return list.get(center);
		} else {
			return ((double) (list.get(center - 1) + list.get(center))) / 2;
		}
	}

	// 005 Longest Palindromic Substring //TIME OUT TODO
	public String longestPalindrome(String s){
		String maxStr = null;
		int maxLen = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				String str = s.substring(i, j);
				if (isPalindrome(str) && str.length() > maxLen) {
					maxStr = str;
					maxLen = str.length();
				}
			}
		}
		return maxStr;
	}

	private boolean isPalindrome(String s) {
		int l = s.length();
		for (int i = 0; i < l / 2; i++) {
			if (s.charAt(i) != s.charAt(l - 1 - i)) {
				return false;
			}
		}
		return true;
	}
	
	//006 ZigZag Conversion  TODO
	public String convert(String s, int numRows) {
		int inx = numRows + numRows - 2;
		char[] array = s.toCharArray();
		
		List<Character> list = new ArrayList<>();
		for(int i = 0; i < array.length; i += inx){
			for(int j = 0; j < numRows; j++){
				list.add(array[inx * i + j]);
				list.add(array[inx * (i + 1) - j]);
			}
		}
		Character[] obj = new Character[s.length()];
		list.toArray(obj);
		return Arrays.toString(obj);
    }
}
