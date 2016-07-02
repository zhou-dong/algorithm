package org.dzhou.practice.medium;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Given an array of integers, find out whether there are two distinct indices i
 * and j in the array such that the difference between nums[i] and nums[j] is at
 * most t and the difference between i and j is at most k.
 * 
 * @author zhoudong
 *
 *         reference:
 *         
 *         http://bookshadow.com/weblog/2015/06/03/leetcode-contains-duplicate-iii/
 *         http://blog.csdn.net/xudli/article/details/46323247
 *
 *         “滑动窗口” + TreeSet
 * 
 *         TreeSet数据结构（Java）使用红黑树实现，是平衡二叉树的一种。
 * 
 *         该数据结构支持如下操作：
 * 
 *         1. floor()方法返set中≤给定元素的最大元素；如果不存在这样的元素，则返回 null。
 * 
 *         2. ceiling()方法返回set中≥给定元素的最小元素；如果不存在这样的元素，则返回 null。
 * 
 */
public class ContainsDuplicateIII {

	public class Solution {

		public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

			if (k < 1 || t < 0 || nums == null || nums.length < 2)
				return false;

			SortedSet<Long> set = new TreeSet<Long>();

			for (int i = 0; i < nums.length; i++) {
				SortedSet<Long> subSet = set.subSet((long) nums[i] - t, (long) nums[i] + t + 1);
				if (!subSet.isEmpty())
					return true;
				if (i >= k)
					set.remove((long) nums[i - k]);
				set.add((long) nums[i]);
			}
			
			return false;
		}

	}

}
