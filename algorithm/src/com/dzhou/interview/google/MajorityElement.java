package com.dzhou.interview.google;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * /** Given an array of size n, find the majority element. The majority element
 * is the element that appears more than ⌊ n/2 ⌋ times.
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

	// 思路一:最笨的方法, 挨个检测此元素出现的次数, 时间复杂度O(n2)
	// Time Limit Exceeded
	class Brute_Force_Solution {
		public int majorityElement(int[] nums) {
			for (int num : nums) {
				if (isMajority(nums, num)) {
					return num;
				}
			}
			return -1;
		}

		private boolean isMajority(int[] nums, int target) {
			int count = 0, halfSize = nums.length / 2;
			for (int num : nums) {
				if (target == num && ++count > halfSize) {
					return true;
				}
			}
			return false;
		}
	}

	// 思路二:用hash table 记录每个元素出现的次数, 然后找出出现最多的那一个. 时间复杂度O(n), 空间复杂度O(n)
	class HashTable_Solution {
		public int majorityElement(int[] nums) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int num : nums) {
				if (map.containsKey(num)) {
					map.put(num, map.get(num) + 1);
				} else {
					map.put(num, 1);
				}
			}
			for (int num : map.keySet()) {
				if (map.get(num) > nums.length / 2) {
					return num;
				}
			}
			return -1;
		}
	}

	// 思路三:先排序, 然后再取n/2的那个元素就是了, 时间复杂度由排序算法决定了. 时间复杂度O(nlogn)
	class Sorted_Solution {
		public int majorityElement(int[] nums) {
			Arrays.sort(nums);
			return nums[nums.length / 2];
		}
	}

	// 思路四:随机抽取一个元素,然后判断他的出现次数是否是大天n/2,因为随机抽取一个的话,抽中的概率已经大于1/2了.最优时间复杂度为O(n)
	class Random_Pick_Solution {
		public int majorityElement(int[] nums) {
			Random random = new Random();
			int target = next(nums, random);
			while (!isMajority(nums, target)) {
				target = next(nums, random);
			}
			return target;
		}

		private int next(int[] nums, Random random) {
			return nums[random.nextInt(nums.length)];
		}

		private boolean isMajority(int[] nums, int target) {
			int count = 0, halfSize = nums.length / 2;
			for (int num : nums) {
				if (target == num && ++count > halfSize) {
					return true;
				}
			}
			return false;
		}
	}

	// 思路五:两个不同的数删除, 留到最后的就是我们要的结果. 或者这方法可以理解为投票,
	// 先假设是第一个是的, 然后再遍历到他时就给他加一票, 否则减一票, 票数为0时换个元素. 时间复杂度 O(n) 等等等…
	class Vote_Solution {
		public int majorityElement(int[] nums) {
			int current = 0, count = 0;
			for (int num : nums) {
				if (count == 0) {
					current = num;
					count++;
				} else if (current == num) {
					count++;
				} else {
					count--;
				}
			}
			return current;
		}
	}
}
