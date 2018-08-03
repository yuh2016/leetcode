package com.leetcode.yh;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

import java.util.Map;
import java.util.Optional;
import java.util.Stack;

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
		String maxStr = "";

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
		//不对
		char[] array = s.toCharArray();
		for(int i=0; i<s.length(); i++){
			int left = i;
			int right = s.length() - 1;
			while(array[right] != array[left] && right >= left && right > 0){
				right --;
			}
			
			if(right == 0){
				String tmp = String.valueOf(array[left]);
				if(tmp.length() > maxStr.length()) maxStr = tmp;
				continue;
			}
			
			int rightMax = right;
			while(left < right && right >= 0 && left <s.length() && array[right] == array[left]){
				right --;
				left ++;
			}
			
			if(right - left == 1 || left - right == 1 || right == left){
				String tmp = s.substring(i, rightMax + 1);
				if(tmp.length() > maxStr.length()) maxStr = tmp;
			}
		}*/

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
		if (strs.length == 0) {
			return "";
		}
		String first = strs[0];
		int max = first.length();
		for (int i = 1; i < strs.length; i++) {
			int tmp = 0;
			int len = first.length() < strs[i].length() ? first.length() : strs[i].length();
			for (int j = 0; j < len; j++) {
				if (first.charAt(j) == strs[i].charAt(j)) {
					tmp++;
				} else {
					break;
				}
			}
			if (tmp < max) {
				max = tmp;
			}
		}

		if (max == 0) {
			return "";
		} else {
			return first.substring(0, max);
		}
	}

	// 15. 3Sum
	// find all a,b,c that matches a+b+c=0
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int index = nums.length;
			for (int j = i + 1; j < nums.length - 1; j++) {
				for (int k = j + 1; k < index; k++) {
					if (nums[i] + nums[j] + nums[k] == 0) {
						list.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[k])));
						index = k;
						break;
					} else if (nums[i] + nums[j] + nums[k] > 0) {
						index = k;
						break;
					}
				}
			}
		}
		return list;
	}

	// 使用二分查找
	public List<List<Integer>> threeSum2(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < nums.length; j++) {
				if (j > 1 && nums[j] == nums[j - 1] && j != i + 1) {
					continue;
				}
				int index = binarySearch(nums, j + 1, 0 - nums[i] - nums[j]);
				if(index > j){
					List<Integer> sums = new ArrayList<>();
					sums.add(nums[i]);
					sums.add(nums[j]);
					sums.add(nums[index]);
					list.add(sums);
				}
			}
		}

		return list;
	}

	/**
	 * 二分查找
	 * @param nums
	 * @param n
	 * @return
	 */
	public int binarySearch(int[] array, int left, int key) {
	    int right = array.length - 1;

	    // 这里必须是 <=
	    while (left <= right) {
	        int mid = (left + right) / 2;
	        if (array[mid] == key) {
	            return mid;
	        }
	        else if (array[mid] < key) {
	            left = mid + 1;
	        }
	        else {
	            right = mid - 1;
	        }
	    }

	    return -1;
	}
	
	//16. 3Sum Closest
	//居然没嫌我慢。。。
	public int threeSumClosest(int[] nums, int target) {
		int num = nums[0] + nums[1] + nums[2];
		int flag = Math.abs(num - target);
        for(int i = 0; i<nums.length; i++){
        	for(int j=i + 1; j<nums.length; j++){
        		for(int k= j + 1; k<nums.length; k++){
        			int plus = nums[i] + nums[j] + nums[k];
        			int tmp = Math.abs(plus - target);
        			if(tmp < flag){
        				num = plus;
        				flag= tmp;
        			}
        		}
        	}
        }
		return num;
    }
	
	//大神的方法
	/*
	Similar to 3 Sum problem, use 3 pointers to point current element, 
	next element and the last element. If the sum is less than target, 
	it means we have to add a larger element so next element move to the next. 
	If the sum is greater, it means we have to add a smaller element so last element move to the second last element. 
	Keep doing this until the end. Each time compare the difference between sum and target, 
	if it is less than minimum difference so far, then replace result with it, otherwise keep iterating.
	
	用3个指针，一个指向当前元素，第二个指向下一个元素，第三个指向最后元素
	如果三个数相加>target, 则第三个元素前移；如果三个数相加<target，则第二个元素后移
	
	求2个数相加也可用这种方法。
	善用指针。
	*/
	public int threeSumClosest2(int[] num, int target) {
        int result = num[0] + num[1] + num[num.length - 1];
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1, end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }

	// 17.Letter Combinations of a Phone Number
	// 1-, 2-abc, 3-def, 4-ghi, 5-jkl, 6-mno, 7-pqrs, 8-tuv, 9-wxyz
	public List<String> letterCombinations(String digits) {
		if (digits.length() == 0) {
			return new ArrayList<>();
		}
		char[] nums = digits.toCharArray();

		Map<String, List<String>> letters = new HashMap<>();
		letters.put("2", new ArrayList<>(Arrays.asList("a", "b", "c")));
		letters.put("3", new ArrayList<>(Arrays.asList("d", "e", "f")));
		letters.put("4", new ArrayList<>(Arrays.asList("g", "h", "i")));
		letters.put("5", new ArrayList<>(Arrays.asList("j", "k", "l")));
		letters.put("6", new ArrayList<>(Arrays.asList("m", "n", "o")));
		letters.put("7", new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
		letters.put("8", new ArrayList<>(Arrays.asList("t", "u", "v")));
		letters.put("9", new ArrayList<>(Arrays.asList("w", "x", "y", "z")));

		List<String> result = letters.get(String.valueOf(nums[0]));
		for (int i = 1; i < nums.length; i++) {
			result = combineTwoString(result, letters.get(String.valueOf(nums[i])));
		}
		return result;
	}
	
	/**
	 * @param a
	 * @param b
	 * @return
	 */
	public List<String> combineTwoString(List<String> a, List<String> b) {
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < a.size(); i++) {
			for (int j = 0; j < b.size(); j++) {
				result.add(a.get(i) + b.get(j));
			}
		}
		return result;
	}
	
	//18. 4Sum
	/*
	 ==!  一点点挤牙膏写出来的。。。各种情况没考虑清楚。。。
	 */
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if(i > 0 && nums[i] == nums[i - 1]){
				continue;
			}
			for (int j = i + 1; j < nums.length; j++) {
				if(j > i + 1 && nums[j] == nums[j - 1]){
					continue;
				}
				int left = j + 1;
				int right = nums.length - 1;
				
				Integer lastLeft = left;
				Integer lastRight = right;
				boolean leftChange = false;
				boolean rightChange = false;
				while(left < right){
					if(leftChange && rightChange){
						if(nums[lastLeft] == nums[left] && nums[lastRight] == nums[right]){
							left ++;
							right --;
							leftChange = true;
							rightChange = true;
							continue;
						}
					}
					if(leftChange && !rightChange && nums[lastLeft] == nums[left]){
						left ++;
						leftChange = true;
						continue;
					}
					
					if(rightChange && !leftChange && nums[lastRight] == nums[right]){
						right --;
						rightChange = true;
						continue;
					}
					leftChange = false;
					rightChange = false;
					int sum = nums[i] + nums[j] + nums[left] + nums[right];
					if(sum == target){
						List<Integer> list = new ArrayList<>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[left]);
						list.add(nums[right]);
						result.add(list);
						lastLeft = left;
						lastRight = right;
						left ++;
						right --;
						leftChange = true;
						rightChange = true;
					}else if(sum < target){
						left ++;
						leftChange = true;
					}else{
						//sum > target
						right --;
						rightChange = true;
					}
				}
			}
		}
		return result;
    }

	// 17, excellent solutions
	public List<String> letterCombinations2(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		if (digits.isEmpty())
			return ans;
		String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		ans.add("");
		for (int i = 0; i < digits.length(); i++) {
			int x = Character.getNumericValue(digits.charAt(i));
			while (ans.peek().length() == i) {
				String t = ans.remove();
				for (char s : mapping[x].toCharArray())
					ans.add(t + s);
			}
		}
		return ans;
	}

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	/**
	 * 19. Remove Nth Node From End of List
	 * 
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (n == 0)
			return head;
		if (head == null)
			return null;
		int len = 1;
		List<ListNode> nodeList = new ArrayList<>();
		nodeList.add(head);
		ListNode next = head.next;
		while (next != null) {
			len++;
			nodeList.add(next);
			next = next.next;
		}
		if (n == len) {
			return head.next;
		}

		int index = len - n;

		if (index + 1 > len - 1) {
			nodeList.get(index - 1).next = null;
		} else {
			nodeList.get(index - 1).next = nodeList.get(index + 1);
		}
		return head;
	}

	// solutions: 2个指针，a比b多n,所以a到最后时，b就在len-n处，直接修改b的next就行了。
	public ListNode removeNthFromEnd2(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode first = dummy;
		ListNode second = dummy;
		// Advances first pointer so that the gap between first and second is n
		// nodes apart
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

	// 20. Valid Parentheses
	// '(', ')', '{', '}', '[' and ']'
	// 判断括号是否有效：有关就有闭；顺序一致
	public boolean isValid(String s) {
		char[] chars = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		HashMap<Character, Character> cmap = new HashMap<>();
		cmap.put('(', ')');
		cmap.put('{', '}');
		cmap.put('[', ']');
		for (char c : chars) {
			if (cmap.containsKey(c)) {
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				Character chr = stack.pop();
				if (chr == null || cmap.get(chr) == null || !cmap.get(chr).equals(c)) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	// 简洁方法：
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

	// 21. Merge Two Sorted Lists
	// Input: 1->2->4, 1->3->4
	// Output: 1->1->2->3->4->4
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode first = l1;
		ListNode second = l2;
		ListNode head = new ListNode(0);
		ListNode tmp = head;
		while (first != null && second != null) {
			if (first.val <= second.val) {
				tmp.next = new ListNode(first.val);
				first = first.next;
			} else {
				tmp.next = new ListNode(second.val);
				second = second.next;
			}
			tmp = tmp.next;
		}
		if (first == null) {
			tmp.next = second;
		} else {
			tmp.next = first;
		}
		return head.next;
	}
	
	//22. Generate Parentheses
	public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        
        return list;
    }
	
	//23. Merge k Sorted Lists
	/*
	 Input:
	[
	  1->4->5,
	  1->3->4,
	  2->6
	]
	Output: 1->1->2->3->4->4->5->6
	 */
	public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        ListNode first = lists[0];
        int index = 1;
        while(index < lists.length){
        	first = mergeTwoLists(first, lists[index]);
        	index ++;
        }
        return first;
    }
	
	public ListNode mergeKLists2(ListNode[] lists) {
        List<Integer> nums = new ArrayList<>();
        for(int i = 0; i < lists.length; i++){
        	ListNode node = lists[i];
        	while(node != null){
        		nums.add(node.val);
        		node = node.next;
        	}
        }
        
        if(nums.isEmpty()) return null;
        ListNode first = new ListNode(0);
        nums.stream().sorted().map(num -> new ListNode(num)).reduce(first, (a, b) -> {a.next = b; return b;});
        return first.next;
    }
}
