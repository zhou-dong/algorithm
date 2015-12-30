package org.dzhou.interview.linkedlist;

/**
 * Given two (singly) linked list, determine if the two lists intersect. Return
 * the intersection node. Note that the intersection is defined based on
 * reference, not value. That is, if the kth node of the first linked list is
 * the exact same node (by reference) as the jth node of the second linked list,
 * then they are intersecting.
 * 
 * @author DONG ZHOU
 *
 *         First way: use hash table
 * 
 *         Second way: If two linked list intersection, after intersection node,
 *         all the node will be same, Of course the last node will be same ;
 */
public class Intersection {

	public static Node findIntersection(Node first, Node second) {
		if (first == null || second == null)
			return null;
		Result firstResult = getTailAndSize(first);
		Result secondResult = getTailAndSize(second);
		if (firstResult.tail != secondResult.tail)
			return null;
		Node longer = firstResult.size > secondResult.size ? first : second;
		Node shorter = firstResult.size > secondResult.size ? second : first;
		longer = getKthNode(longer, Math.abs(firstResult.size - secondResult.size));
		while (longer != shorter) {
			shorter = shorter.next;
			longer = longer.next;
		}
		return longer;
	}

	static class Result {
		int size;
		Node tail;

		public Result(int size, Node tail) {
			this.size = size;
			this.tail = tail;
		}
	}

	static Result getTailAndSize(Node node) {
		int size = 0;
		Node tail = null;
		while (node != null) {
			tail = node;
			size++;
			node = node.next;
		}
		return new Result(size, tail);
	}

	static Node getKthNode(Node head, int k) {
		Node current = head;
		for (; k > 0 && current != null; k--)
			current = current.next;
		return current;
	}

}
