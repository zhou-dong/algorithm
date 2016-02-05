package org.dzhou.interview.recursiondynamicprogramming;

import java.util.Stack;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 */
public class HanoiTower {

	class Tower {
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
			if (!disks.isEmpty() && disks.peek() <= d) {
				return false;
			} else {
				disks.push(data);
				return true;
			}
		}

		public void moveTopTo(Tower t) {
			int top = disks.pop();
			t.add(top);
		}
	}

}