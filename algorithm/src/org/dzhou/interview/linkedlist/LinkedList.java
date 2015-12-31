package org.dzhou.interview.linkedlist;

public class LinkedList {

	public static void main(String[] args) {
		// initial head
		Node head = new Node(-1);
		// append elements to tail
		for (int i = 0; i < 20; i++)
			head.appendToTail(i);
		System.out.print("Initial list: ");
		print(head);
		head = Node.deleteNode(head, 19);
		head = Node.deleteNode(head, 18);
		head = Node.deleteNode(head, -1);
		System.out.print("removed list: ");
		print(head);
		// append duplicate data
		for (int i = 0; i < 10; i++)
			head.appendToTail(i);
		System.out.print("Add dups: ");
		print(head);
		DeleteDups.deleteDups(head);
		System.out.print("RM dups: ");
		print(head);
		for (int i = 0; i < 10; i++)
			head.appendToTail(i + 3);
		System.out.print("Add dups: ");
		print(head);
		System.out.print("RM dups: ");
		DeleteDups.deleteDups2(head);
		print(head);
		KthToLast.printKthTolast(head, 4);
		System.out.println(KthToLast.kthNodeToLast(head, 4).data);
		System.out.println(KthToLast.kthNodeToLast2(head, 4).data);
		System.out.println(KthToLast.kthNodeToLast3(head, 4).data);
		DeleteMiddleNode.deleteNode(head);
		DeleteMiddleNode.deleteNode(head);
		DeleteMiddleNode.deleteNode(head);
		System.out.print("RM first 3 node: ");
		print(head);
		testPartition();
		testPartition2();
		testReverse();
		isPalindrome();
		isPalindrome2();
		isPalindrome3();
		testSizeAndTail();
		testIntersection();
		testLoopDetection();
	}

	public static void testPartition() {
		Node node = new Node(10);
		for (int i = 0; i < 20; i++) {
			int data = (int) (Math.random() * 30);
			node.appendToTail(data);
		}
		print(node);
		node = Partition.partition(node, 15);
		print(node);
	}

	public static void testPartition2() {
		Node node = new Node(10);
		for (int i = 0; i < 20; i++) {
			int data = (int) (Math.random() * 30);
			node.appendToTail(data);
		}
		print(node);
		node = Partition.partition2(node, 15);
		print(node);
	}

	public static void testReverse() {
		Node node = new Node(10);
		for (int i = 0; i < 20; i++) {
			int data = (int) (Math.random() * 30);
			node.appendToTail(data);
		}
		print(node);
		Node reverse = Palindrome.getReverse(node);
		print(reverse);
	}

	public static void isPalindrome() {
		Node node = new Node(0);
		node.appendToTail(1);
		node.appendToTail(2);
		node.appendToTail(1);
		node.appendToTail(0);
		boolean isEqual = Palindrome.isPalindrome(node);
		System.out.println(isEqual);
	}

	public static void isPalindrome2() {
		Node node = new Node(0);
		node.appendToTail(1);
		node.appendToTail(2);
		node.appendToTail(1);
		node.appendToTail(0);
		boolean isEqual = Palindrome.isPalindrome2(node);
		System.out.println(isEqual);
	}

	public static void isPalindrome3() {
		Node node = new Node(0);
		node.appendToTail(1);
		node.appendToTail(2);
		node.appendToTail(1);
		node.appendToTail(0);
		boolean isEqual = Palindrome.isPalindrome3(node);
		System.out.println(isEqual);
	}

	static void print(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	static void testSizeAndTail() {
		Node node = new Node(10);
		for (int i = 0; i < 10; i++) {
			int data = (int) (Math.random() * 30);
			node.appendToTail(data);
		}
		print(node);
		Intersection.Result result = Intersection.getTailAndSize(node);
		System.out.println(result.size);
		System.out.println(result.tail.data);
	}

	static void testIntersection() {
		Node first = new Node(10);
		for (int i = 0; i < 6; i++) {
			int data = (int) (Math.random() * 30);
			first.appendToTail(data);
		}
		Node intersection = new Node(77);
		first.next = intersection;
		for (int i = 0; i < 4; i++) {
			int data = (int) (Math.random() * 30);
			first.appendToTail(data);
		}
		Node second = new Node(13);
		for (int i = 0; i < 4; i++) {
			int data = (int) (Math.random() * 30);
			second.appendToTail(data);
		}
		second.next = intersection;
		Node result = Intersection.findIntersection(first, second);
		System.out.println(result.data);
	}

	static void testLoopDetection() {
		Node node = new Node(88);
		Node loopPointer = null;
		for (int i = 0; i < 6; i++) {
			int data = (int) (Math.random() * 30);
			node.appendToTail(data);
			loopPointer = node.next;
		}
		loopPointer.next = node;
		Node result = LoopDetection.findBegining(node);
		System.out.println(result.data);
	}
}
