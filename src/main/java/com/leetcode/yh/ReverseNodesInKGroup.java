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
		//ԭ�ڵ�
        ListNode lastFirst = null;	//�ϸ��ֻ���1�Žڵ�
        ListNode currentFirst = null;	//��ǰ�ֻ���1�Žڵ�
        
        //�½ڵ�
        ListNode first = null;	//��һ���ڵ�ָ��
        ListNode current = null;	//��ǰ�ڵ�ָ��
        ListNode tmp = new ListNode(head.val);	//�ϸ��ڵ�ָ��
        currentFirst = tmp;//��ǰ��Ϊ1�Žڵ�
        ListNode left = head;	//ʣ��ڵ㣬ÿ�����ֻ���1�Ÿ�ֵ
        head = head.next;
        
        int cnt = 2;	//Ŀǰ
        while(head != null){
        	//��ǰ�ڵ�
        	current = new ListNode(head.val);
        	//��һ���ڵ�
        	if(tmp != null){
        		current.next = tmp;
        	}
        	tmp = current;
        	//�ƶ�����һ���ڵ�
        	
        	//K���ڵ��е�1�Žڵ�
        	if(cnt % k == 1){
        		//�����ǰ1�Žڵ㲻Ϊ�գ���Ϊ��һ��1�Žڵ�
        		if(currentFirst != null){
        			lastFirst = currentFirst;
        		}
        		//����ǰ�ڵ���Ϊ��ǰ1�Žڵ�
        		currentFirst = current;
        		left = head;	//���¸�ֵʣ��ڵ�
        	}
        	head = head.next;
        	//����K���ڵ��е�K�Žڵ㣬һ���ֻؾ�����
        	if(cnt % k == 0){
        		//�����һ��1�Žڵ㲻Ϊ�գ�����һ��1�Žڵ��NextΪ��ǰ�ڵ�
        		if(lastFirst != null){
        			lastFirst.next = current;
        			lastFirst = null;
        		}
        		//���ͷ�ڵ�Ϊ�գ�����ǰ�ڵ���Ϊͷ�ڵ㡣ֻ��һ�Ρ�
        		if(first == null){
        			first = current;
        		}
        		//ÿ��һ���ֻذ�tmp���
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
