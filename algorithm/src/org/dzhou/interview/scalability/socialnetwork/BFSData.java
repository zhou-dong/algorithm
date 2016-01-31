package org.dzhou.interview.scalability.socialnetwork;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFSData {

	public Queue<PathNode> toVisit = new LinkedList<>();
	public HashMap<Integer, PathNode> visited = new HashMap<>();

	public BFSData(Person root) {
		PathNode sourcePath = new PathNode(root, null);
		toVisit.add(sourcePath);
		visited.put(root.getPersonID(), sourcePath);
	}

	public boolean isFinished() {
		return toVisit.isEmpty();
	}

}
