package com.leetcode.yh;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

		/*
		 * if (s.length() == 1) { return s; } for (int i = 0; i < s.length();
		 * i++) { char c = s.charAt(i); char next = s.charAt(i + 1); if (c ==
		 * next) { for (int j = i, k = i + 1; j >= 0 && k < s.length(); j--,
		 * k++) {
		 * 
		 * } } else { for (int j = i - 1, k = i + 1; j >= 0 && k < s.length();
		 * j--, k++) {
		 * 
		 * } } }
		 */

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
				char b = array[inx * i + numRows - j];
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

	// 008. String to Integer (atoi)
	public int myAtoi(String str) {
		String tmp = str.trim();
		if (tmp.length() == 0) {
			return 0;
		}

		char first = tmp.charAt(0);
		if (first == '+' || first == '-' || (first >= '0' && first <= '9')) {

		} else {
			return 0;
		}

		char[] chars = tmp.toCharArray();
		int start = 0, end = -1, index = 0;
		while (index < tmp.length()) {
			char c = chars[index];
			if (index == 0) {
				if (c == '+' || c == '-' || (c >= '0' && c <= '9')) {
					index++;
					end = 0;
				} else {
					break;
				}
			} else {
				if (c >= '0' && c <= '9') {
					end++;
					index++;
					continue;
				} else {
					break;
				}
			}
		}
		if (start >= 0) {
			String num = tmp.substring(start, end + 1);
			if (num.length() == 1 && (num.startsWith("+") || num.startsWith("-"))) {
				return 0;
			}
			BigInteger n = new BigInteger(num);
			if (n.compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE))) == 1) {
				return Integer.MAX_VALUE;
			}
			if (n.compareTo(new BigInteger(String.valueOf(Integer.MIN_VALUE))) == -1) {
				return Integer.MIN_VALUE;
			}
			return n.intValue();
		}
		return 0;
	}

	// 009. Palindrome Number
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}

		int reverse = 0, tmp = 0, origial = x;
		while (x != 0) {
			tmp = x % 10;
			x = x / 10;
			reverse = reverse * 10 + tmp;
		}
		return reverse == origial;
	}

	/**
	 * 10. Regular Expression Matching
	 * 
	 * @param s
	 *            string
	 * @param p
	 *            pattern
	 * @return
	 */
	public boolean isMatch(String s, String p) {
		// .表示任意字符，*表示0次或多次
		String stmp = null;
		String ptmp = null;
		for (int i = 0; i < p.length(); i++) {
			stmp = s.substring(i, i + 1);
			ptmp = p.substring(i, i + 1);
			if (stmp.equals(ptmp) || stmp.equals(".")) {
				continue;
			} else {

			}
		}
		return false;
	}

	/**
	 * 11. Container With Most Water //TIME OUT //TODO
	 * 
	 * @param height
	 * @return
	 */
	public int maxArea(int[] height) {
		int max = 0;
		int tmp = 0;
		int maxHeight = 0;
		for (int i = 0; i < height.length - 1; i++) {
			if (height[i] > maxHeight) {
				maxHeight = height[i];
			} else if (i > 0 && height[i] <= maxHeight) {
				continue;
			}

			for (int j = i + 1; j < height.length; j++) {
				tmp = (j - i) * min(height[i], height[j]);
				if (tmp > max) {
					max = tmp;
				}
			}
		}
		return max;
	}

	private int min(int a, int b) {
		if (a < b) {
			return a;
		} else {
			return b;
		}
	}

	// 12. Integer to Roman
	/*
	 * 
	 *
	 * I 1 V 5 X 10 L 50 C 100 D 500 M 1000
	 * 
	 * I can be placed before V (5) and X (10) to make 4 and 9. X can be placed
	 * before L (50) and C (100) to make 40 and 90. C can be placed before D
	 * (500) and M (1000) to make 400 and 900.
	 * 
	 * num range: 0 ~ 3999
	 */
	public String intToRoman(int num) {
		int index[] = { 1000, 500, 100, 50, 10, 5, 1 };
		String romanIndex[] = { "M", "D", "C", "L", "X", "V", "I" };
		String convertIndex[] = { "C", "C", "X", "X", "I", "I", null };
		int result[] = new int[7];
		int tmp = num;
		for (int i = 0; i < index.length; i++) {
			result[i] = tmp / index[i];
			tmp = tmp % index[i];
		}

		StringBuilder romanStr = new StringBuilder();
		for (int j = 0; j < result.length; j++) {
			if (result[j] > 0 && result[j] % 4 == 0) {
				// j=0时num >= 4000, 不考虑
				// j=1时，index[1]=500, 不可能等于4
				if (j > 1) {
					// 有前一位, -> 9， 删除前一个字符串，加上9
					if (result[j - 1] == 1) {
						romanStr.deleteCharAt(romanStr.length() - 1);
						romanStr.append(convertIndex[j - 1]).append(romanIndex[j - 2]);
					} else {
						// 没有前一位, -> 4， 直接加上4
						romanStr.append(convertIndex[j - 1]).append(romanIndex[j - 1]);
					}
				}
			} else {
				for (int k = 0; k < result[j]; k++) {
					romanStr.append(romanIndex[j]);
				}
			}
		}

		return romanStr.toString();
	}

	// 13. Roman to Integer
	public int romanToInt(String s) {
		int index[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String romanIndex[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < index.length; i++) {
			map.put(romanIndex[i], index[i]);
		}

		int num = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i < s.length() - 1 && map.containsKey(s.substring(i, i + 2))) {
				num += map.get(s.substring(i, i + 2));
				i++;
			} else {
				num += map.get(s.substring(i, i + 1));
			}
		}
		return num;
	}

	// 14. Longest Common Prefix
	public String longestCommonPrefix(String[] strs) {
		if(strs.length == 0){
			return "";
		}
		String first = strs[0];
		int max = first.length();
		for (int i = 1; i < strs.length; i++) {
			int tmp = 0;
			int len = first.length() < strs[i].length() ? first.length() : strs[i].length();
			for(int j = 0; j < len ; j++){
				if(first.charAt(j) == strs[i].charAt(j)){
					tmp++;
				}else{
					break;
				}
			}
			if(tmp < max){
				max = tmp;
			}
		}
		
		if(max == 0){
			return "";
		}else{
			return first.substring(0, max);
		}
	}
}
