package org.dzhou.research.cci.linkedlist;

/**
 * Implement an algorithm to delete a node in the middle of a single linked
 * list, given only access to that node
 * 
 * 要求：删除传入的node
 * 
 * Solution：先复制下一个结点到本结点，然后删除下个结点。
 * 
 * 缺点：这种方法不能删除最后一个node
 * 
 * @author zhoudong
 * 
 */
public class DeleteMiddleNode {

	class LinkedListNode {
		int data;
		LinkedListNode next;
	}

	public class Solution {
		boolean deleteNode(LinkedListNode n) {
			if (n == null || n.next == null)
				return false;
			n.data = n.next.data;
			n.next = n.next.next;
			return true;
		}
	}

}
