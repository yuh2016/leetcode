package com.leetcode.yh;

import org.junit.Test;


import junit.framework.TestCase;

public class SwapNodesInPairsTest extends TestCase {
	private static SwapNodesInPairs t = new SwapNodesInPairs();
	
	@Test
	public void testSwapPairs(){
		SwapNodesInPairs.ListNode first = t.new ListNode(1);
		first.next = t.new ListNode(2);
		first.next.next = t.new ListNode(3);
		first.next.next.next = t.new ListNode(4);
		first.next.next.next.next = t.new ListNode(5);
		first.next.next.next.next.next = t.new ListNode(6);
		
		SwapNodesInPairs.ListNode tmp = t.swapPairs(first);
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
