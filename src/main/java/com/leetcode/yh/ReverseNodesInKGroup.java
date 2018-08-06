package com.leetcode.yh;

public class ReverseNodesInKGroup {
/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.

 */
	public ListNode reverseKGroup(ListNode head, int k) {
		if(head == null) return null;
		if(head.next == null || k == 1) return head;
		//原节点
        ListNode lastFirst = null;	//上个轮回中1号节点
        ListNode currentFirst = null;	//当前轮回中1号节点
        
        //新节点
        ListNode first = null;	//第一个节点指针
        ListNode current = null;	//当前节点指针
        ListNode tmp = new ListNode(head.val);	//上个节点指针
        currentFirst = tmp;//当前沦为1号节点
        ListNode left = head;	//剩余节点，每次在轮回中1号赋值
        head = head.next;
        
        int cnt = 2;	//目前
        while(head != null){
        	//当前节点
        	current = new ListNode(head.val);
        	//上一个节点
        	if(tmp != null){
        		current.next = tmp;
        	}
        	tmp = current;
        	//移动到下一个节点
        	
        	//K个节点中的1号节点
        	if(cnt % k == 1){
        		//如果当前1号节点不为空，设为上一个1号节点
        		if(currentFirst != null){
        			lastFirst = currentFirst;
        		}
        		//将当前节点设为当前1号节点
        		currentFirst = current;
        		left = head;	//重新赋值剩余节点
        	}
        	head = head.next;
        	//到了K个节点中的K号节点，一个轮回就完了
        	if(cnt % k == 0){
        		//如果上一个1号节点不为空，这上一个1号节点的Next为当前节点
        		if(lastFirst != null){
        			lastFirst.next = current;
        			lastFirst = null;
        		}
        		//如果头节点为空，将当前节点设为头节点。只设一次。
        		if(first == null){
        			first = current;
        		}
        		//每过一个轮回把tmp清空
        		tmp = null;
        	}
        	cnt ++;
        }

        if(lastFirst != null){
			lastFirst.next = left;
		}
        
        if(first == null){
			first = left;
		}
		return first;
    }
}
