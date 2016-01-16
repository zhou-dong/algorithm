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

	public class Coordinate {
		int row;
		int col;

		public Coordinate(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public class MazeNode {
		private Coordinate coordinate;
		private List<MazeNode> neighbors;

		public MazeNode(Coordinate coordinate) {
			this.coordinate = coordinate;
		}

		public List<MazeNode> getNeighbors() {
			return neighbors;
		}

		public void setNeighbors(List<MazeNode> neighbors) {
			this.neighbors = neighbors;
		}

		public Coordinate getCoordinate() {
			return coordinate;
		}

		public void setCoordinate(Coordinate coordinate) {
			this.coordinate = coordinate;
		}
	}

	public List<Coordinate> dfs(Coordinate startCoordinate, Coordinate goalCoordinate) {
		if (startCoordinate == null || goalCoordinate == null)
			return Collections.emptyList();
		MazeNode start = new MazeNode(startCoordinate);
		MazeNode goal = new MazeNode(goalCoordinate);
		Map<MazeNode, MazeNode> parentMap = new HashMap<>();
		if (!dfsSearch(start, goal, parentMap))
			return Collections.emptyList();
		return constructPath(start, goal, parentMap);
	}

	private List<Coordinate> constructPath(MazeNode start, MazeNode goal,
			Map<MazeNode, MazeNode> parentMap) {
		List<Coordinate> path = new LinkedList<>();
		MazeNode current = goal;
		while (current != start) {
			path.add(current.getCoordinate());
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
			if (current == goal)
				return true;
			for (MazeNode next : current.getNeighbors()) {
				if (visited.contains(next))
					continue;
				visited.add(next);
				parentMap.put(next, current);
				toExplore.push(next);
			}
		}
		return false;
	}

}
