package com.leetcode.yh;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseNodesInKGroupTest {
	private static ReverseNodesInKGroup t = new ReverseNodesInKGroup();
	
	@Test
	public void testReverseKGroup(){
		ListNode first = new ListNode(1);
		first.next = new ListNode(2);
		first.next.next = new ListNode(3);
		first.next.next.next = new ListNode(4);
		first.next.next.next.next = new ListNode(5);
		first.next.next.next.next.next = new ListNode(6);
		first.next.next.next.next.next.next = new ListNode(7);
		first.next.next.next.next.next.next.next = new ListNode(8);
		
		ListNode tmp = t.reverseKGroup(first, 3);
		assertEquals(3, tmp.val);
		tmp = tmp.next;
		assertEquals(2, tmp.val);
		tmp = tmp.next;
		assertEquals(1, tmp.val);
		tmp = tmp.next;
		assertEquals(6, tmp.val);
		tmp = tmp.next;
		assertEquals(5, tmp.val);
		tmp = tmp.next;
		assertEquals(4, tmp.val);
		tmp = tmp.next;
		assertEquals(7, tmp.val);
		tmp = tmp.next;
		assertEquals(8, tmp.val);
		
	}
}
