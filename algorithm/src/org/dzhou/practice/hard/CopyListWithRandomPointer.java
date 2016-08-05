package org.dzhou.practice.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Copy List with Random Pointer
 * 
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 * 
 * @author zhoudong
 *
 */
public class CopyListWithRandomPointer {

	// Definition for singly-linked list with a random pointer.
	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};

	// Solution with hashMap
	public class Solution {
		public RandomListNode copyRandomList(RandomListNode head) {
			if (head == null)
				return null;
			Map<RandomListNode, RandomListNode> map = createMap(head);
			addRelation(head, map);
			return map.get(head);
		}

		private Map<RandomListNode, RandomListNode> createMap(RandomListNode head) {
			Map<RandomListNode, RandomListNode> map = new HashMap<>();
			while (head != null) {
				map.put(head, new RandomListNode(head.label));
				head = head.next;
			}
			return map;
		}

		private void addRelation(RandomListNode head, Map<RandomListNode, RandomListNode> map) {
			while (head != null) {
				if (head.next != null)
					map.get(head).next = map.get(head.next);
				if (head.random != null)
					map.get(head).random = map.get(head.random);
				head = head.next;
			}
		}
	}

	/**
	 * reference :
	 * https://siddontang.gitbooks.io/leetcode-solution/content/linked_list/
	 * copy_list_with_random_pointer.html
	 */

	public class Solution1 {
		public RandomListNode copyRandomList(RandomListNode head) {
			if (head == null)
				return null;
			copyNext(head);
			copyRandom(head);
			return split(head);
		}

		private void copyNext(RandomListNode head) {
			while (head != null) {
				RandomListNode newNode = new RandomListNode(head.label);
				newNode.next = head.next;
				newNode.random = head.random;
				head.next = newNode;
				head = newNode.next;
			}
		}

		private void copyRandom(RandomListNode head) {
			while (head != null) {
				if (head.random != null)
					head.next.random = head.random.next;
				head = head.next.next;
			}
		}

		private RandomListNode split(RandomListNode head) {
			RandomListNode newHead = head.next;
			while (head != null) {
				RandomListNode temp = head.next;
				head.next = temp.next;
				head = head.next;
				if (temp.next != null) {
					temp.next = temp.next.next;
				}
			}
			return newHead;
		}
	}
}
