package org.dzhou.interview.treeandgraph.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Maze {

	class Coordinate {

		int row;
		int col;

		public Coordinate(int row, int col) {
			this.row = row;
			this.col = col;
		}

	}

	class MazeNode {

		public MazeNode(int row, int col) {

		}

		private List<MazeNode> neighbors = null;

		public List<MazeNode> getNeighbors() {
			return neighbors;
		}

		public void setNeighbors(List<MazeNode> neighbors) {
			this.neighbors = neighbors;
		}

	}

	List<MazeNode> dfs(int startRow, int startCol, int endRow, int endCol) {

		MazeNode start = new MazeNode(startRow, startCol);
		MazeNode goal = new MazeNode(endRow, endCol);

		if (start == null || goal == null) {
			return Collections.emptyList();
		}

		Map<MazeNode, MazeNode> parentMap = new HashMap<>();

		if (!dfsSearch(start, goal, parentMap)) {
			return Collections.emptyList();
		}

		return (List<MazeNode>) constructPath(start, goal, parentMap);
	}

	private List<MazeNode> constructPath(MazeNode start, MazeNode goal,
			Map<MazeNode, MazeNode> parentMap) {
		LinkedList<MazeNode> path = new LinkedList<>();
		MazeNode current = goal;
		while (current != start) {
			path.addFirst(current);
			current = parentMap.get(current);
		}
		return path;

	}

	private boolean dfsSearch(MazeNode start, MazeNode goal, Map<MazeNode, MazeNode> parentMap) {

		Set<MazeNode> visited = new HashSet<>();
		Stack<MazeNode> toExplore = new Stack<>();
		toExplore.push(start);

		while (!toExplore.isEmpty()) {
			MazeNode current = toExplore.pop();
			if (current == goal) {
				return true;
			}
			List<MazeNode> neighbors = current.getNeighbors();

			for (MazeNode next : neighbors) {
				if (visited.contains(next)) {
					continue;
				}
				visited.add(next);
				parentMap.put(next, current);
				toExplore.push(next);
			}
		}

		return false;
	}
}
