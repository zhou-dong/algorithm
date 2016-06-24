package org.dzhou.practice.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * For example: 2, [[1,0]]
 * 
 * There are a total of 2 courses to take. To take course 1 you should have
 * finished course 0. So it is possible.
 * 
 * 2, [[1,0],[0,1]]
 * 
 * There are a total of 2 courses to take. To take course 1 you should have
 * finished course 0, and to take course 0 you should also have finished course
 * 1. So it is impossible.
 * 
 * Note: The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices.
 * 
 * @author zhoudong
 *
 *         此问题等价于判断有向图中是否有环。如果存在环路，无法完成拓扑排序，也就不可能修完所有的课程。
 */
public class CourseSchedule {

	public class Solution {

		public boolean canFinish(int numCourses, int[][] prerequisites) {

			if (numCourses <= 0 || prerequisites == null || prerequisites.length == 0)
				return true;

			// Construct graph
			Map<Integer, List<Integer>> adjList = new HashMap<>();
			for (int[] edge : prerequisites) {
				if (!adjList.containsKey(edge[1]))
					adjList.put(edge[1], new ArrayList<>());
				adjList.get(edge[1]).add(edge[0]);
			}

			int[] visited = new int[numCourses];
			for (int i = 0; i < numCourses; i++) {
				if (visited[i] == 0 && hasCycle(i, visited, adjList)) {
					return false;
				}
			}
			return true;
		}

		private boolean hasCycle(int vertexId, int[] visited, Map<Integer, List<Integer>> adjList) {
			if (adjList.containsKey(vertexId)) {
				visited[vertexId] = 1;
				for (int v1 : adjList.get(vertexId)) {
					if (visited[v1] == 1) {
						return true;
					}
					if (visited[v1] == 0 && hasCycle(v1, visited, adjList)) {
						return true;
					}
				}
			}
			visited[vertexId] = 2;
			return false;
		}

	}

}
