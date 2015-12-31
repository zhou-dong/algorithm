package org.dzhou.interview.linkedlist;

/**
 * 
 * Practice of "Cracking the code interview" question.
 * 
 * 
 * Given a circular linked list, implement an algorithm that returns the node at
 * the beginning of the loop.
 * 
 * 
 * @author DONG ZHOU
 *
 *         设slower的速度为1，faster的速度为2. 在一个loop中:
 * 
 *         1. 如果slower和faster从同一个点出发，他们会在起始点相遇。Like:
 * 
 *         --- 1 * steps + loopSize = 2 * steps ; steps = loopSize ;
 * 
 *         2. 如果slower从0点出发，faster从k点出发，他们会 loopSize - k的地方相遇。
 *
 *         --- 1 * steps + loopSize = 2 * steps + k; steps = loopSize - k ;
 * 
 *         -----------------------------------------------------------------
 * 
 *         1. Create two pointer, FastPointer and slowPointer
 * 
 *         2. Move FastPointer at rate of 2 steps and SlowPointer at rate of 1
 *         step.
 * 
 *         3. When they collide. move SlowPointer to the LinkedListHead. Keep
 *         FastPointer where it is.
 * 
 *         4. Move SlowPointer and FastPointer at a rate of one step. Return the
 *         new collision point.
 */
public class LoopDetection {

	public static Node findBegining(Node head) {
		Node slow = head;
		Node fast = head;
		// find the collide pointer
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				break;
		}
		// check if list is loop
		if (fast == null || fast.next == null)
			return null;
		slow = head;
		while (slow != head) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

}
