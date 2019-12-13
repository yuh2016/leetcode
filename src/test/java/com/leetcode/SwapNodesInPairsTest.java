package com.leetcode;

import org.junit.Test;


import junit.framework.TestCase;

public class SwapNodesInPairsTest extends TestCase {
	private static SwapNodesInPairs t = new SwapNodesInPairs();
	
	@Test
	public void testSwapPairs(){
		ListNode first = new ListNode(1);
		first.next = new ListNode(2);
		first.next.next = new ListNode(3);
		first.next.next.next = new ListNode(4);
		first.next.next.next.next = new ListNode(5);
		first.next.next.next.next.next = new ListNode(6);
		
		ListNode tmp = t.swapPairs(first);
		assertEquals(2, tmp.val);
		tmp = tmp.next;
		assertEquals(1, tmp.val);
		tmp = tmp.next;
		assertEquals(4, tmp.val);
		tmp = tmp.next;
		assertEquals(3, tmp.val);
		tmp = tmp.next;
		assertEquals(6, tmp.val);
		tmp = tmp.next;
		assertEquals(5, tmp.val);
		tmp = tmp.next;
		
	}
}
