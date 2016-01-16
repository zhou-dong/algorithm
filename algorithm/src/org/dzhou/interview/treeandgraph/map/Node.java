package org.dzhou.interview.treeandgraph.map;

import java.util.List;

public class Node {

	private Location location;

	private List<Edge> edges;

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

}
