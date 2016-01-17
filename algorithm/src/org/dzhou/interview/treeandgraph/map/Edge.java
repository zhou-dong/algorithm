package org.dzhou.interview.treeandgraph.map;

public class Edge {

	private GeographicPoint start;
	private GeographicPoint end;
	private String roadName;
	private String roadType;
	private double distance;

	public Edge() {
	}

	public Edge(GeographicPoint start, GeographicPoint end, String roadName, String roadType,
			double distance) {
		super();
		this.start = start;
		this.end = end;
		this.roadName = roadName;
		this.roadType = roadType;
		this.distance = distance;
	}

	public GeographicPoint getStart() {
		return start;
	}

	public void setStart(GeographicPoint start) {
		this.start = start;
	}

	public GeographicPoint getEnd() {
		return end;
	}

	public void setEnd(GeographicPoint end) {
		this.end = end;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getRoadName() {
		return roadName;
	}

	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}

	public String getRoadType() {
		return roadType;
	}

	public void setRoadType(String roadType) {
		this.roadType = roadType;
	}

}
