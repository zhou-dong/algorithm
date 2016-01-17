package org.dzhou.interview.treeandgraph.map;

import java.util.LinkedList;
import java.util.List;

public class Vertex {

	private GeographicPoint location;
	private List<Edge> edges;

	public Vertex(GeographicPoint location) {
		super();
		this.location = location;
		this.edges = new LinkedList<>();
	}

	public GeographicPoint getLocation() {
		return location;
	}

	public void setLocation(GeographicPoint location) {
		this.location = location;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

}
