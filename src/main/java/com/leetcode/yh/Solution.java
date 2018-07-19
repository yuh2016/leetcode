package com.leetcode.yh;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.leetcode.yh.Solution.ListNode;

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
	
	//15. 3Sum
	//find all a,b,c that matches a+b+c=0
	public List<List<Integer>> threeSum(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = 0; j < nums.length; j++) {
				
			}
		}
		
		return null;
    }
	
	public void findNums(int sum, int[] nums){
		
	}
	
	// 17.Letter Combinations of a Phone Number
	//1-, 2-abc, 3-def, 4-ghi, 5-jkl, 6-mno, 7-pqrs, 8-tuv, 9-wxyz
	public List<String> letterCombinations(String digits) {
		if(digits.length() == 0){
			return new ArrayList<>();
		}
        char[] nums = digits.toCharArray();
        
        Map<String, List<String>> letters = new HashMap<>();
        letters.put("2", new ArrayList<>(Arrays.asList("a","b","c")));
        letters.put("3", new ArrayList<>(Arrays.asList("d","e","f")));
        letters.put("4", new ArrayList<>(Arrays.asList("g","h","i")));
        letters.put("5", new ArrayList<>(Arrays.asList("j","k","l")));
        letters.put("6", new ArrayList<>(Arrays.asList("m","n","o")));
        letters.put("7", new ArrayList<>(Arrays.asList("p","q","r","s")));
        letters.put("8", new ArrayList<>(Arrays.asList("t","u","v")));
        letters.put("9", new ArrayList<>(Arrays.asList("w","x","y","z")));
        
        List<String> result = letters.get(String.valueOf(nums[0]));
        for(int i=1; i<nums.length; i++){
        	result = combineTwoString(result, letters.get(String.valueOf(nums[i])));
        }
		return result;
    }
	
	/**
	 * @param a
	 * @param b
	 * @return
	 */
	public List<String> combineTwoString(List<String> a, List<String> b){
		List<String> result = new ArrayList<String>();
		for(int i=0; i<a.size(); i++){
			for(int j=0; j<b.size(); j++){
				result.add(a.get(i) + b.get(j));
			}
		}
		return result;
	}
	
	//17, excellent solutions
	public List<String> letterCombinations2(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		if(digits.isEmpty()) return ans;
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		for(int i =0; i<digits.length();i++){
			int x = Character.getNumericValue(digits.charAt(i));
			while(ans.peek().length()==i){
				String t = ans.remove();
				for(char s : mapping[x].toCharArray())
					ans.add(t+s);
			}
		}
		return ans;
	}
	
	
	//Definition for singly-linked list.
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
	 
	/**
	 * 19. Remove Nth Node From End of List
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(n == 0) return head;
		if(head == null) return null;
        int len = 1;
        List<ListNode> nodeList = new ArrayList<>();
        nodeList.add(head);
        ListNode next = head.next;
        while(next != null){
        	len ++;
        	nodeList.add(next);
        	next = next.next;
        }
        if(n == len){
        	return head.next;
        }
        
        int index = len - n;
        
        if(index + 1 > len -1){
        	nodeList.get(index - 1).next = null;	
        }else{
        	nodeList.get(index - 1).next = nodeList.get(index + 1);
        }
        return head;
    }
	
	//solutions: 2个指针，a比b多n,所以a到最后时，b就在len-n处，直接修改b的next就行了。
	public ListNode removeNthFromEnd2(ListNode head, int n) {
	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    ListNode first = dummy;
	    ListNode second = dummy;
	    // Advances first pointer so that the gap between first and second is n nodes apart
	    for (int i = 1; i <= n + 1; i++) {
	        first = first.next;
	    }
	    // Move first to the end, maintaining the gap
	    while (first != null) {
	        first = first.next;
	        second = second.next;
	    }
	    second.next = second.next.next;
	    return dummy.next;
	}
	
	//20. Valid Parentheses
	//'(', ')', '{', '}', '[' and ']'
	//判断括号是否有效：有关就有闭；顺序一致
	public boolean isValid(String s) {
		char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> cmap = new HashMap<>();
        cmap.put('(', ')');
        cmap.put('{', '}');
        cmap.put('[', ']');
        for(char c : chars){
        	if(cmap.containsKey(c)){
        		stack.push(c);
        	}else{
        		if(stack.isEmpty()){
        			return false;
        		}
        		Character chr = stack.pop();
        		if(chr == null || cmap.get(chr) == null || !cmap.get(chr).equals(c)){
        			return false;
        		}
        	}
        }
        return stack.isEmpty();
    }
	
	
	//简洁方法：
	public boolean isValid2(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}
}
