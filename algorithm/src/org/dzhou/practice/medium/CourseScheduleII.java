package org.dzhou.practice.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, return
 * the ordering of courses you should take to finish all courses.
 * 
 * There may be multiple correct orders, you just need to return one of them. If
 * it is impossible to finish all courses, return an empty array.
 * 
 * For example: 2, [[1,0]]
 * 
 * There are a total of 2 courses to take. To take course 1 you should have
 * finished course 0. So the correct course order is [0,1]
 * 
 * 4, [[1,0],[2,0],[3,1],[3,2]]
 * 
 * There are a total of 4 courses to take. To take course 3 you should have
 * finished both courses 1 and 2. Both courses 1 and 2 should be taken after you
 * finished course 0. So one correct course order is [0,1,2,3]. Another correct
 * ordering is[0,2,1,3].
 * 
 * Note: The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices.
 *
 * Hints:
 * 
 * 1 .This problem is equivalent to finding the topological order in a directed
 * graph. If a cycle exists, no topological ordering exists and therefore it
 * will be impossible to take all courses.
 * 
 * 2. Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera
 * explaining the basic concepts of Topological Sort.
 * 
 * 3. Topological sort could also be done via BFS.
 * 
 * @author zhoudong
 * 
 *         因为只要返回任意一种合法的拓扑排序结果即可，所以只需在BFS过程中记录下来先后访问的节点即可。
 * 
 */
public class CourseScheduleII {

	public class Solution {

		public int[] findOrder(int numCourses, int[][] prerequisites) {

			int[] result = new int[numCourses];
			Arrays.fill(result, -1);
			if (prerequisites == null || prerequisites.length == 0) {
				for (int i = 0; i < numCourses; i++)
					result[i] = i;
				return result;
			}

			// Construct graph
			Map<Integer, List<Integer>> graph = new HashMap<>();
			for (int[] edge : prerequisites) {
				if (!graph.containsKey(edge[1]))
					graph.put(edge[1], new LinkedList<>());
				graph.get(edge[1]).add(edge[0]);
			}

			// records the number of prerequisites of each course
			int[] counter = new int[numCourses];
			for (int[] edge : prerequisites)
				counter[edge[0]]++;

			// stores courses that have no prerequisites
			Queue<Integer> queue = new LinkedList<>();
			for (int i = 0; i < numCourses; i++) {
				if (counter[i] == 0)
					queue.add(i);
			}

			int index = 0;
			while (!queue.isEmpty()) {
				int course = queue.remove();
				result[index] = course;
				index++;
				if (graph.get(course) != null) {
					for (int other : graph.get(course)) {
						counter[other]--;
						if (counter[other] == 0)
							queue.add(other);
					}
				}
			}

			if (result[numCourses - 1] == -1)
				return new int[0];
			else
				return result;
		}

	}

}
