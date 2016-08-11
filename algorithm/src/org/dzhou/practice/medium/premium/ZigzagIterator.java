package org.dzhou.practice.medium.premium;

import java.util.Iterator;
import java.util.List;

/**
 * 281. Zigzag Iterator
 * 
 * Given two 1d vectors, implement an iterator to return their elements
 * alternately.
 * 
 * For example, given two 1d vectors:
 * 
 * v1 = [1, 2]<br>
 * v2 = [3, 4, 5, 6] <br>
 * By calling next repeatedly until hasNext returns false, the order of elements
 * returned by next should be: [1, 3, 2, 4, 5, 6].
 * 
 * Follow up: What if you are given k 1d vectors? How well can your code be
 * extended to such cases?
 * 
 * Clarification for the follow up question - Update (2015-09-18): <br>
 * The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases.
 * If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For
 * example, given the following input:
 * 
 * [1,2,3] <br>
 * [4,5,6,7] <br>
 * [8,9] <br>
 * It should return [1,4,8,2,5,9,3,6,7].
 * 
 * @author zhoudong
 *
 */
public class ZigzagIterator {

	Iterator<Integer> iterator1;
	Iterator<Integer> iterator2;
	boolean isFirst = false;

	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		iterator1 = v1.iterator();
		iterator2 = v2.iterator();
	}

	public int next() {
		if (!iterator1.hasNext()) {
			return iterator2.next();
		}
		if (!iterator2.hasNext()) {
			return iterator1.next();
		}
		isFirst = !isFirst;
		if (isFirst) {
			return iterator1.next();
		} else {
			return iterator2.next();
		}
	}

	public boolean hasNext() {
		return iterator1.hasNext() || iterator2.hasNext();
	}


}
/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * 
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * 
 * while (i.hasNext()) v[f()] = i.next();
 */
