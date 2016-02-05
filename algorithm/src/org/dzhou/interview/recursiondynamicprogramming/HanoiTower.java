package org.dzhou.interview.recursiondynamicprogramming;

import java.util.Stack;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 */
public class HanoiTower {

	static class Tower {
		private Stack<Integer> disks;
		private int index;

		public Tower(int index) {
			disks = new Stack<>();
			this.index = index;
		}

		public int index() {
			return index;
		}

		public boolean add(int data) {
			if (!disks.isEmpty() && disks.peek() <= data)
				return false;
			else {
				disks.push(data);
				return true;
			}
		}

		public boolean moveTopTo(Tower t) {
			return t.add(disks.pop());
		}

		public void moveDisks(int n, Tower destination, Tower buffer) {
			if (n < 1)
				return;
			moveDisks(n - 1, buffer, destination);
			moveTopTo(destination);
			buffer.moveDisks(n - 1, destination, this);
		}
	}

	public static void main(String[] args) {
		int n = 3;
		Tower[] towers = new Tower[n];
		for (int i = 0; i < 3; i++)
			towers[i] = new Tower(i);
		for (int i = n - 1; i >= 0; i++)
			towers[0].add(i);
		towers[0].moveDisks(n, towers[2], towers[1]);
	}

}