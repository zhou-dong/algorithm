package org.dzhou.interview.linkedlist;

public class KthToLast {

	public static int printKthTolast(Node head, int k) {
		if (head == null)
			return 0;
		int index = printKthTolast(head.next, k) + 1;
		if (index == k)
			System.out.println(head.data);
		return index;
	}

	private static class ReturnObj {
		int index = 0;
		Node result = null;
	}

	public static Node kthNodeToLast(Node head, int k) {
		return kthToLast(head, k).result;
	}

	private static ReturnObj kthToLast(Node head, int k) {
		if (head == null)
			return new ReturnObj();
		ReturnObj rObj = kthToLast(head.next, k);
		rObj.index++;
		if (rObj.index == k)
			rObj.result = head;
		return rObj;
	}

	private static class Index {
		int index = 0;
	}

	public static Node kthNodeToLast2(Node head, int k) {
		return kthToLast(head, k, new Index());
	}

	private static Node kthToLast(Node head, int k, Index index) {
		if (head == null)
			return null;
		Node result = kthToLast(head.next, k, index);
		index.index++;
		if (index.index == k)
			return head;
		return result;
	}

	public static Node kthNodeToLast3(Node head, int k) {
		Node node1 = head;
		Node node2 = head;
		for (int i = 0; i < k; i++) {
			if (node1 == null)
				return null;
			node1 = node1.next;
		}
		while (node1 != null) {
			node1 = node1.next;
			node2 = node2.next;
		}
		return node2;
	}

}
