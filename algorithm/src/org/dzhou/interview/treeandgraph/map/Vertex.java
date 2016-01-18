package org.dzhou.interview.treeandgraph.map;

import java.util.LinkedList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {

	private GeographicPoint location;
	private List<Edge> edges;

	private double distance;
	private double actualDistance;

	public Vertex(GeographicPoint location) {
		super();
		this.location = location;
		this.edges = new LinkedList<>();
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Vertex))
			return false;
		return ((Vertex) o).getLocation().equals(this.location);
	}

	@Override
	public int compareTo(Vertex o) {
		return ((Double) this.getDistance()).compareTo((Double) o.getDistance());
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

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getActualDistance() {
		return actualDistance;
	}

	public void setActualDistance(double actualDistance) {
		this.actualDistance = actualDistance;
	}

}
