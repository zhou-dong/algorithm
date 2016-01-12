package org.dzhou.interview.linkedlist;

/**
 * 
 * Simple implement of LinkedList.
 * 
 * When use this kind of method to implement Linked List, should careful of if
 * multiple objects need a reference to the linked list, if the head of linked
 * list has changed.
 * 
 * @author DONG ZHOU
 *
 */
public class Node {

	int data;
	Node next = null;

	public Node(int data) {
		this.data = data;
	}

	public void append(Node prev) {
		this.next = prev.next;
		prev.next = this;
	}

	public void appendToTail(int data) {
		Node node = this;
		while (node.next != null)
			node = node.next;
		node.next = new Node(data);
	}

	public static Node deleteNode(Node head, int data) {
		if (head.data == data)
			return head.next;
		Node runner = head;
		while (runner.next != null) {
			if (runner.next.data == data) {
				runner.next = runner.next.next;
				return head;
			}
			runner = runner.next;
		}
		return head;
	}

}
