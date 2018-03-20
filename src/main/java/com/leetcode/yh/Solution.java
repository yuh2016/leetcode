package com.leetcode.yh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
	public String longestPalindrome(String s) {
		String maxStr = null;
		/*
		 * int maxLen = 0; for (int i = 0; i < s.length(); i++) { for (int j = i
		 * + 1; j <= s.length(); j++) { String str = s.substring(i, j); if
		 * (isPalindrome(str) && str.length() > maxLen) { maxStr = str; maxLen =
		 * str.length(); } } }
		 */

		if (s.length() == 1) {
			return s;
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			char next = s.charAt(i + 1);
			if (c == next) {
				for (int j = i, k = i + 1; j >= 0 && k < s.length(); j--, k++) {

				}
			} else {
				for (int j = i - 1, k = i + 1; j >= 0 && k < s.length(); j--, k++) {

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

	// 006 ZigZag Conversion TODO
	public String convert(String s, int numRows) {
		int inx = numRows + numRows - 2;
		char[] array = s.toCharArray();

		List<Character> list = new ArrayList<>();
		for (int i = 0; i < array.length; i += inx) {
			for (int j = 0; j < numRows; j++) {
				char a = array[inx * i + j];
				list.add(a);
				char b = array[inx * (i + 1) - j];
				if (a != b && j > 0) {
					list.add(array[inx * (i + 1) - j]);
				}
			}
		}
		Character[] obj = new Character[s.length()];
		list.toArray(obj);
		
		
		

		return Arrays.toString(obj);
	}

	// 007 Reverse Integer
	public int reverseInteger(int num) {
		int temp = num / 10;
		int mob = num % 10;
		long result = mob;
		while (temp != 0) {
			result *= 10;
			mob = temp % 10;
			temp = temp / 10;
			result += mob;
		}
		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
			return 0;
		}
		return Long.valueOf(result).intValue();
	}
}
