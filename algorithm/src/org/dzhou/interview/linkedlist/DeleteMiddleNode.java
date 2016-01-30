package org.dzhou.interview.linkedlist;

/**
 * Practice of "cracking the code interview"
 * 
 * Implement an algorithm to delete a node in the middle (i.e., any node but the
 * first and last node, not necessarily the exact middle) of a singly linked
 * list, given only access to that node.
 * 
 * Actually I don't the means of this question.
 * 
 * @author DONG ZHOU
 *
 */
public class DeleteMiddleNode {

	public static boolean deleteNode(Node node) {
		if (node == null || node.next == null)
			return false;
		Node next = node.next;
		node.data = next.data;
		node.next = next.next;
		return true;
	}

}
