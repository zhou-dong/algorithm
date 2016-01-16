package org.dzhou.interview.treeandgraph.map;

public class Location {

	private double latitude;
	private double longtitude;
	private String address;

	public Location() {
	}

	public Location(String address) {
		this(0d, 0d, address);
	}

	public Location(double latitude, double longtitude) {
		this(latitude, longtitude, null);
	}

	public Location(double latitude, double longtitude, String address) {
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.address = address;
	}

	public void clearCoordinates() {
		this.latitude = 0d;
		this.longtitude = 0d;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
