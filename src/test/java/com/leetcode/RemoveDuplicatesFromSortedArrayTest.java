package com.leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class RemoveDuplicatesFromSortedArrayTest {
	
	RemoveDuplicatesFromSortedArray t = new RemoveDuplicatesFromSortedArray();
	
	@Test
	public void testRemoveDuplicates(){
		int nums[] = new int[]{0,0,1,1,1,2,2,3,3,4};
		int result = t.removeDuplicates(nums);
		assertEquals(5, result);

		int nums2[] = new int[]{1, 1};
		int result2 = t.removeDuplicates(nums2);
		assertEquals(1, result);
	}
}
