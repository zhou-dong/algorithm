package com.dzhou.interview.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 207. Course Schedule
 * 
 * Difficulty: Medium
 * 
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * For example:
 * 
 * 2, [[1,0]] There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0. So it is possible.
 * 
 * 2, [[1,0],[0,1]] There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0, and to take course 0 you should also have
 * finished course 1. So it is impossible.
 * 
 * 
 * @author zhoudong
 *
 */
public class CourseSchedule {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, Set<Integer>> graph = createGraph(prerequisites);
		for (int vertex : graph.keySet()) {
			if (hasCycle(graph, vertex)) {
				return false;
			}
		}
		return true;
	}

	Set<Integer> visiting = new HashSet<>();
	Set<Integer> visited = new HashSet<>();

	private boolean hasCycle(Map<Integer, Set<Integer>> map, int vertex) {
		if (!map.containsKey(vertex)) {
			return false;
		}
		if (visited.contains(vertex)) {
			return false;
		}
		if (visiting.contains(vertex)) {
			return true;
		}
		visiting.add(vertex);
		for (int connect : map.get(vertex)) {
			if (hasCycle(map, connect)) {
				return true;
			}
		}
		visiting.remove(vertex);
		visited.add(vertex);
		return false;
	}

	private Map<Integer, Set<Integer>> createGraph(int[][] edges) {
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int[] edge : edges) {
			if (!map.containsKey(edge[1])) {
				map.put(edge[1], new HashSet<>());
			}
			map.get(edge[1]).add(edge[0]);
		}
		return map;
	}

}
