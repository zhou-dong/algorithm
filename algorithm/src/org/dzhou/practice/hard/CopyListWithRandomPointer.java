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

}
