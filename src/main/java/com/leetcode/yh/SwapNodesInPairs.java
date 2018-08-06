package com.leetcode.yh;

public class SwapNodesInPairs {
	//Given 1->2->3->4, you should return the list as 2->1->4->3.
	public ListNode swapPairs(ListNode head) {
		if(head == null) return null;
		if(head.next == null) return head;
		
		ListNode result = new ListNode(head.next.val);
		ListNode finalNode = result;
		result.next = new ListNode(head.val);
		ListNode tmp = head.next.next;
		ListNode flag = null;
		
		int cnt = 0;
		while(tmp != null){
			if(cnt % 2 == 0){
				flag = tmp;
			}else{
				ListNode next = new ListNode(tmp.val); 
				result = result.next;
				result.next = new ListNode(tmp.val);
				if(flag != null){
					result = result.next;
					result.next = new ListNode(flag.val);
					flag = null;
				}
			}
			tmp = tmp.next;
			cnt ++;
		}
		
		if(flag != null){
			result = result.next;
			result.next = new ListNode(flag.val);
		}
		return finalNode;
	}
}
