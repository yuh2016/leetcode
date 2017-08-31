package com.leetcode.yh;

import org.junit.Test;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {
	private static Solution t = new Solution();
	
	@Test
	public void testFindMedianSortedArrays(){
		int[] nums1 = new int[]{1, 3};
		int[] nums2 = new int[]{2};
		double result1 = t.findMedianSortedArrays(nums1, nums2);
		assertEquals(result1, 2.0);
		
		int[] nums3 = new int[]{1, 2};
		int[] nums4 = new int[] {3, 4};
		double result2 = t.findMedianSortedArrays(nums3, nums4);
		assertEquals(result2, 2.5);
	}
}
