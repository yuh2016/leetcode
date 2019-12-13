package com.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKLists {
	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
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

	// 方法一：利用之前的mergeTwoLists
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0)
			return null;
		if (lists.length == 1)
			return lists[0];
		ListNode first = lists[0];
		int index = 1;
		while (index < lists.length) {
			first = mergeTwoLists(first, lists[index]);
			index++;
		}
		return first;
	}

	// 方法二：直接取出全部数据排序后生成新的node
	public ListNode mergeKLists2(ListNode[] lists) {
		List<Integer> nums = new ArrayList<>();
		for (int i = 0; i < lists.length; i++) {
			ListNode node = lists[i];
			while (node != null) {
				nums.add(node.val);
				node = node.next;
			}
		}

		if (nums.isEmpty())
			return null;
		ListNode first = new ListNode(0);
		nums.stream().sorted().map(num -> new ListNode(num)).reduce(first, (a, b) -> {
			a.next = b;
			return b;
		});
		return first.next;
	}

	// 网上看到的其他方法：
	// 利用优先级队列，按每个listNode的val排序
	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0)
			return null;

		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				if (o1.val < o2.val)
					return -1;
				else if (o1.val == o2.val)
					return 0;
				else
					return 1;
			}
		});

		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;

		// 所有node加到queue里面，按每个链的第一个node的val排序
		for (ListNode node : lists)
			if (node != null)
				queue.add(node);

		// 如果queue不为空，则取出第一个node（第一个的val按排序是最小的）
		while (!queue.isEmpty()) {
			tail.next = queue.poll();
			tail = tail.next;

			// 如果第一个node还有Next， 则把next放入queue中，queue又会自动排序，将最小的放在前面
			if (tail.next != null)
				queue.add(tail.next);
		}
		return dummy.next;
	}

	// 使用递归
	public static ListNode mergeKLists3(ListNode[] lists) {
		return partion(lists, 0, lists.length - 1);
	}

	public static ListNode partion(ListNode[] lists, int start, int end) {
		if (start == end)
			return lists[start];
		if (start < end) {
			int q = (start + end) / 2;
			ListNode l1 = partion(lists, start, q);
			ListNode l2 = partion(lists, q + 1, end);
			return merge(l1, l2);
		} else
			return null;
	}

	// This function is from Merge Two Sorted Lists.
	public static ListNode merge(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		if (l1.val < l2.val) {
			l1.next = merge(l1.next, l2);
			return l1;
		} else {
			l2.next = merge(l1, l2.next);
			return l2;
		}
	}
}
