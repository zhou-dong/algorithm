package org.dzhou.practice.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example: Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * 
 * Note: Each element in the result must be unique. The result can be in any
 * order.
 * 
 * @author zhoudong
 *
 */
public class IntersectionOfTwoArrays {

	class Solution {
		public int[] intersection(int[] nums1, int[] nums2) {
			Set<Integer> set1 = new HashSet<>();
			Set<Integer> set2 = new HashSet<>();

			for (int i : nums1)
				set1.add(i);
			for (int i : nums2)
				if (set1.contains(i))
					set2.add(i);

			int[] result = new int[set2.size()];

			Iterator<Integer> iterator = set2.iterator();
			int index = 0;
			while (iterator.hasNext()) {
				result[index] = iterator.next();
				index++;
			}

			return result;
		}
	}

	class Solution1 {
		public int[] intersection(int[] nums1, int[] nums2) {
			Arrays.sort(nums1);
			Arrays.sort(nums2);
			int i = 0, j = 0;
			Set<Integer> set = new HashSet<>();
			while (i < nums1.length && j < nums2.length) {
				if (nums1[i] == nums2[j]) {
					set.add(nums1[i]);
					i++;
					j++;
				} else if (nums1[i] < nums2[j])
					i++;
				else
					j++;
			}
			int index = 0;
			int[] result = new int[set.size()];
			for (Iterator<Integer> iterator = set.iterator(); iterator.hasNext(); index++) {
				result[index] = iterator.next();
			}
			return result;
		}
	}

}
