package org.dzhou.practice.medium.premium;

import java.util.Iterator;
import java.util.List;

/**
 * Implement an iterator to flatten a 2d vector.
 * 
 * For example, <br>
 * Given 2d vector = <br>
 * [ <br>
 * --[1,2], <br>
 * --[3], <br>
 * --[4,5,6] <br>
 * ] <br>
 * By calling next repeatedly until hasNext returns false, the order of elements
 * returned by next should be: [1,2,3,4,5,6].
 * 
 * Hint:
 * 
 * 1.How many variables do you need to keep track? <br>
 * 2.Two variables is all you need. Try with x and y. <br>
 * 3.Beware of empty rows. It could be the first few rows. <br>
 * 4.To write correct code, think about the invariant to maintain. What is it?
 * 5.The invariant is x and y must always point to a valid point in the 2d
 * vector. Should you maintain your invariant ahead of time or right when you
 * need it? <br>
 * 6.Not sure? Think about how you would implement hasNext(). Which is more
 * complex? <br>
 * 7.Common logic in two different places should be refactored into a common
 * method. <br>
 * 
 * @author zhoudong
 *
 */
public class Flatten2DVector {

	public class Vector2D implements Iterator<Integer> {

		Iterator<List<Integer>> iterator = null;
		Iterator<Integer> current = null;

		public Vector2D(List<List<Integer>> vec2d) {
			if (vec2d == null || vec2d.isEmpty())
				return;
			iterator = vec2d.iterator();
			current = iterator.next().iterator();
		}

		@Override
		public Integer next() {
			return current.next();
		}

		@Override
		public boolean hasNext() {
			if (current == null)
				return false;
			while (!current.hasNext() && iterator.hasNext())
				current = iterator.next().iterator();
			return current.hasNext();
		}
	}

	/**
	 * Your Vector2D object will be instantiated and called as such: Vector2D i
	 * = new Vector2D(vec2d); while (i.hasNext()) v[f()] = i.next();
	 */
}
