package org.dzhou.practice.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 * 
 * @author zhoudong
 *
 *         reference from: http://www.madcoder.cn/leetcode-majority-element.html
 *
 *         算法分析: 这道题目解法就多了, 下面就列举几种简单好用的解法.
 * 
 *         思路一:最笨的方法, 挨个检测此元素出现的次数, 时间复杂度O(n2)
 * 
 *         思路二:用hash table 记录每个元素出现的次数, 然后找出出现最多的那一个. 时间复杂度O(n), 空间复杂度O(n)
 * 
 *         思路三:先排序, 然后再取n/2的那个元素就是了, 时间复杂度由排序算法决定了. 时间复杂度O(nlogn)
 * 
 *         思路四:随机抽取一个元素,然后判断他的出现次数是否是大天n/2,因为随机抽取一个的话,抽中的概率已经大于1/2了.最优时间复杂度为O(n)
 * 
 *         思路五:两个不同的数删除, 留到最后的就是我们要的结果. 或者这方法可以理解为投票, 先假设是第一个是的, 然后再遍历到他时就给他加一票,
 *         否则减一票, 票数为0时换个元素. 时间复杂度 O(n) 等等等…
 */
public class MajorityElement {

	public class Solution {

		public int majorityElement(int[] nums) {
			Map<Integer, Integer> map = new HashMap<>();
			int half = nums.length / 2;
			for (int x : nums) {
				if (map.containsKey(x))
					map.put(x, map.get(x) + 1);
				else
					map.put(x, 1);
				if (map.get(x) > half)
					return x;
			}
			throw new NoSuchElementException();
		}

	}

	public class Solution1 {

		public class Solution {

			public int majorityElement(int[] num) {
				int time = 0, result = 0;
				for (int x : num) {
					if (time == 0)
						result = x;
					if (result == x) {
						time++;
					} else {
						time--;
					}
				}
				return result;
			}

		}

	}

}
