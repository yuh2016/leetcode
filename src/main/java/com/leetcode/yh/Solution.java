package com.leetcode.yh;

import java.math.BigInteger;
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
		 

		/*if (s.length() == 1) {
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
		}*/

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
	
	//008. String to Integer (atoi)
	public int myAtoi(String str) {
        String tmp = str.trim();
        if(tmp.length() == 0){
        	return 0;
        }
        
        char first = tmp.charAt(0);
        if(first == '+' || first == '-' || (first >= '0' && first <= '9')){
        	
        }else{
        	return 0;
        }
        
        char[] chars = tmp.toCharArray();
        int start = 0, end = -1, index = 0;
        while(index < tmp.length()){
        	char c = chars[index];
        	if(index == 0){
        		if(c == '+' || c == '-' || (c >= '0' && c <= '9')){
        			index ++;
        			end = 0;
	        	}else{
	        		break;
	        	}
        	}else{
        		if(c >= '0' && c <= '9'){
        			end++;
        			index ++;
        			continue;
        		}else{
        			break;
        		}
        	}
        }
        if(start >= 0){
        	String num = tmp.substring(start, end + 1);
        	if(num.length() == 1 && (num.startsWith("+") || num.startsWith("-"))){
        		return 0;
        	}
        	BigInteger n = new BigInteger(num);
        	if(n.compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE))) == 1){
        		return Integer.MAX_VALUE;
        	}
        	if(n.compareTo(new BigInteger(String.valueOf(Integer.MIN_VALUE))) == -1){
        		return Integer.MIN_VALUE;
        	}
        	return n.intValue();
        }
		return 0;
    }
	
	//009. Palindrome Number
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		
        int reverse = 0, tmp = 0, origial = x;
		while(x != 0){
			tmp = x % 10;
			x = x / 10;
			reverse = reverse * 10 + tmp;
		}
		return reverse == origial;
    }
	
	/**
	 * //10. Regular Expression Matching
	 * @param s string
	 * @param p pattern
	 * @return
	 */
	public boolean isMatch(String s, String p) {
        //.表示任意字符，*表示0次或多次
		String stmp = null;
		String ptmp = null;
		for(int i = 0; i < p.length(); i++){
			stmp = s.substring(i, i+1);
			ptmp = p.substring(i, i+1);
			if(stmp.equals(ptmp) || stmp.equals(".")){
				continue;
			}else{
				
			}
		}
		return false;
    }
	
	/**
	 * 11. Container With Most Water
	 * @param height
	 * @return
	 */
	public int maxArea(int[] height) {
		int max = 0;
		int tmp = 0;
		for(int i=0; i<height.length - 1; i++){
			for(int j = i + 1; j < height.length; j++){
				tmp = (j - i) * min(height[i], height[j]);
				if(tmp > max){
					max = tmp;
				}
			}
		}
        return max;
    }
	
	private int min(int a, int b){
		if(a < b){
			return a;
		}else{
			return b;
		}
	}
}
