package org.dzhou.practice.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 406. Queue Reconstruction by Height
 * 
 * Difficulty: Medium
 * 
 * Suppose you have a random list of people standing in a queue. Each person is
 * described by a pair of integers (h, k), where h is the height of the person
 * and k is the number of people in front of this person who have a height
 * greater than or equal to h. Write an algorithm to reconstruct the queue.
 * 
 * Note: The number of people is less than 1,100.
 * 
 * Example
 * 
 * Input: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 
 * Output: [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * 
 * @author zhoudong
 *
 */
public class QueueReconstructionByHeight {

	public int[][] reconstructQueue(int[][] people) {
		if (people == null || people.length < 2)
			return people;

		sortByK(people);

		List<int[]> list = new ArrayList<int[]>();
		list.add(people[0]);

		for (int i = 1; i < people.length; i++) {
			int h = people[i][0];
			int k = people[i][1];
			int j = 0;
			boolean flag = true;
			while (j < list.size() && k >= 0 && flag) {
				if (list.get(j)[0] >= h) {
					if (k == 0) {
						flag = false;
						break;
					}
					k--;
				}
				j++;
			}
			list.add(j, people[i]);
		}

		return convertListToArray(list);
	}

	// 按照k排序，k小的放前面，k相同h小的放前面
	private void sortByK(int[][] people) {
		Arrays.sort(people, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] != o2[1]) {
					return o1[1] - o2[1];
				} else {
					return o1[0] - o2[0];
				}
			}
		});
	}

	private int[][] convertListToArray(List<int[]> list) {
		int[][] result = new int[list.size()][2];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
	}

}
