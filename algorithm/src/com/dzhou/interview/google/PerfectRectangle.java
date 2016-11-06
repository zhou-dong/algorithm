package com.dzhou.interview.google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * 391. Perfect Rectangle
 * 
 * Given N axis-aligned rectangles where N > 0, determine if they all together
 * form an exact cover of a rectangular region.
 * 
 * Each rectangle is represented as a bottom-left point and a top-right point.
 * For example, a unit square is represented as [1,1,2,2]. (coordinate of
 * bottom-left point is (1, 1) and top-right point is (2, 2)).
 * 
 * @author zhoudong
 *
 */
public class PerfectRectangle {

	class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Point)) {
				return false;
			}
			if (obj == this) {
				return true;
			}
			Point other = (Point) obj;
			return this.x == other.x && this.y == other.y;
		}
	}

	class Rectangle {
		int left, bottom, right, top;

		Rectangle(int[] rectangle) {
			this(rectangle[0], rectangle[1], rectangle[2], rectangle[3]);
		}

		Rectangle(int left, int bottom, int right, int top) {
			this.left = left;
			this.bottom = bottom;
			this.right = right;
			this.top = top;
		}

		int area() {
			return (top - bottom) * (right - left);
		}

		Point leftBottom() {
			return new Point(left, bottom);
		}

		Point leftTop() {
			return new Point(left, top);
		}

		Point rightBottom() {
			return new Point(right, bottom);
		}

		Point rightTop() {
			return new Point(right, top);
		}

		List<Point> getPoints() {
			List<Point> points = new ArrayList<>(4);
			points.add(leftBottom());
			points.add(leftTop());
			points.add(rightBottom());
			points.add(rightTop());
			return points;
		}

		void expend(Rectangle rectangle) {
			this.left = Math.min(left, rectangle.left);
			this.bottom = Math.min(bottom, rectangle.bottom);
			this.right = Math.max(right, rectangle.right);
			this.top = Math.max(top, rectangle.top);
		}
	}

	public boolean isRectangleCover(int[][] rectangles) {
		Rectangle together = new Rectangle(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
		int sumArea = 0;
		Set<Point> set = new HashSet<>();
		for (int[] item : rectangles) {
			Rectangle rectangle = new Rectangle(item);
			sumArea += rectangle.area();
			together.expend(rectangle);
			toggle(set, rectangle);
		}
		return set.size() == 4 && sumArea == together.area() && contains(set, together);
	}

	private void toggle(Set<Point> set, Rectangle rectangle) {
		for (Point point : rectangle.getPoints()) {
			toggle(set, point);
		}
	}

	private void toggle(Set<Point> set, Point point) {
		if (set.contains(point)) {
			set.remove(point);
		} else {
			set.add(point);
		}
	}

	private boolean contains(Set<Point> set, Rectangle rectangle) {
		for (Point point : rectangle.getPoints()) {
			if (!set.contains(point)) {
				return false;
			}
		}
		return true;
	}

}
