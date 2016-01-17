package org.dzhou.interview.treeandgraph.map;

import java.awt.geom.Point2D.Double;

/**
 * 
 * Copy for study!
 * 
 * @author DONG ZHOU
 *
 */
public class GeographicPoint extends Double {

	private static final long serialVersionUID = 1L;

	public GeographicPoint(double latitude, double longitude) {
		super(latitude, longitude);
	}

	public double distance(GeographicPoint other) {
		return getDist(this.getX(), this.getY(), other.getX(), other.getY());
	}

	private double getDist(double lat1, double lon1, double lat2, double lon2) {
		int R = 6373; // radius of the earth in kilometres
		double lat1rad = Math.toRadians(lat1);
		double lat2rad = Math.toRadians(lat2);
		double deltaLat = Math.toRadians(lat2 - lat1);
		double deltaLon = Math.toRadians(lon2 - lon1);

		double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2) + Math.cos(lat1rad)
				* Math.cos(lat2rad) * Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		double d = R * c;
		return d;
	}

	public String toString() {
		return "Lat: " + getX() + ", Lon: " + getY();
	}

}
