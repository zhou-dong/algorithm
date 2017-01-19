package org.dzhou.os.disk.scheduling;

import java.util.Arrays;

public interface Scheduling {

	public abstract int execute(int[] range, int[] cylinders, int header, int previous);

	public static class FCFS implements Scheduling {

		@Override
		public int execute(int[] range, int[] cylinders, int header, int previous) {
			int total = 0;
			for (int cylinder : cylinders) {
				total += Math.abs(cylinder - header);
				header = cylinder;
			}
			return total;
		}

	}

	public static class SSTF implements Scheduling {

		private class ListNode {
			ListNode prev;
			ListNode next;
			int value;

			ListNode(int value) {
				this.value = value;
			}

			void remove() {
				this.prev.next = this.next;
				this.next.prev = this.prev;
			}
		}

		private class List {
			ListNode head;
			ListNode tail;
			int size;

			List() {
				this.size = 0;
				this.head = new ListNode(-1);
				this.tail = new ListNode(-1);
				head.next = tail;
				tail.prev = head;
			}

			ListNode append(int value) {
				ListNode node = new ListNode(value);
				node.next = tail;
				node.prev = tail.prev;
				tail.prev.next = node;
				tail.prev = node;
				this.size++;
				return node;
			}

			void remove(ListNode node) {
				if (node == null)
					return;
				node.remove();
				this.size--;
			}

			ListNode near(ListNode node) {
				if (this.size == 0)
					return null;
				if (this.size == 1)
					return node;
				if (node.prev == head)
					return node.next;
				if (node.next == tail)
					return node.prev;
				return near(node, node.prev, node.next);
			}

			ListNode near(ListNode node, ListNode prev, ListNode next) {
				int prevInterval = Math.abs(node.value - prev.value);
				int nextInterval = Math.abs(node.value - next.value);
				return prevInterval < nextInterval ? prev : next;
			}

		}

		@Override
		public int execute(int[] range, int[] cylinders, int header, int previous) {
			Arrays.sort(cylinders);
			List list = createList(cylinders);
			ListNode current = startNode(list, header);
			int total = 0, prev = header;
			while (list.size > 0) {
				total += Math.abs(current.value - prev);
				prev = current.value;
				ListNode next = list.near(current);
				list.remove(current);
				current = next;
			}
			return total;
		}

		private List createList(int[] cylinders) {
			List list = new List();
			for (int i = 0; i < cylinders.length; i++) {
				list.append(cylinders[i]);
			}
			return list;
		}

		private ListNode startNode(List list, int header) {
			ListNode result = null;
			int min = Integer.MAX_VALUE;
			ListNode current = list.head;
			for (int i = 0; i < list.size; i++) {
				current = current.next;
				int interval = Math.abs(current.value - header);
				if (interval < min) {
					result = current;
					min = interval;
				}
			}
			return result;
		}

	}

	public static class SCAN {

	}

	public static class CSACN {

	}

	public static class LOOK {

	}

	public static class CLOOK {

	}
}
