package org.dzhou.interview.recursiondynamicprogramming;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.Box;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 *         You have a stack of n boxes, with widths w, heights h， and depths d.
 *         The boxes cannot be rotated and can only be stacked on top of one
 *         another if each box in the stack is strictly larger than the box
 *         above it in width, height, and depth. Implement a method to build the
 *         tallest stack possible, where the height of a stack is the sum of the
 *         heights of each box.
 * 
 *         NOT FINISH!!!
 * 
 */
public class StackOfBoxes {

	int createStack(List<Box> boxes) {
		Collections.sort(boxes, new BoxComparator());
		int maxHeight = 0;
		for (int i = 0; i < boxes.size(); i++) {
			int height = createStack(boxes, i);
			maxHeight = Math.max(maxHeight, height);
		}
		return maxHeight;
	}

	int createStack(List<Box> boxes, int bottomIndex) {
		int maxHeight = 0;
		return maxHeight;
	}

	class BoxComparator implements Comparator<Box> {
		@Override
		public int compare(Box o1, Box o2) {
			return o1.getHeight() - o2.getHeight();
		}
	}

}
