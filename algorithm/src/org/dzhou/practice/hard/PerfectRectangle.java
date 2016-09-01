package org.dzhou.practice.hard;

import java.util.HashSet;
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
 *         reference: http://blog.csdn.net/mebiuw/article/details/52354018
 * 
 *         核心思想就是:能够正好围成一个矩形的情况就是: 有且只有: - 最左下 最左上 最右下 最右上
 *         的四个点只出现过一次,其他肯定是成对出现的(保证完全覆盖) - 上面四个点围成的面积,正好等于所有子矩形的面积之和(保证不重复)
 */
public class PerfectRectangle {

	class Point {
		public int x;
		public int y;

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
			if (!(obj instanceof Point))
				return false;
			if (obj == this)
				return true;
			Point other = (Point) obj;
			return other.x == this.x && other.y == this.y;
		}
	}

	class Rectangle {
		int left;
		int bottom;
		int right;
		int top;

		Rectangle(int[] rectangle) {
			this(rectangle[0], rectangle[1], rectangle[2], rectangle[3]);
		}

		public Rectangle(int left, int bottom, int right, int top) {
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
	}

	private void toggle(Set<Point> set, Point point) {
		if (set.contains(point)) {
			set.remove(point);
		} else {
			set.add(point);
		}
	}

	public boolean isRectangleCover(int[][] rectangles) {
		int left = Integer.MAX_VALUE, bottom = Integer.MAX_VALUE;
		int right = Integer.MIN_VALUE, top = Integer.MIN_VALUE;

		Set<Point> flags = new HashSet<>();

		int totalArea = 0;
		for (int[] item : rectangles) {
			Rectangle rectangle = new Rectangle(item);

			left = Math.min(left, rectangle.left);
			bottom = Math.min(bottom, rectangle.bottom);
			right = Math.max(right, rectangle.right);
			top = Math.max(top, rectangle.top);

			totalArea += rectangle.area();

			toggle(flags, rectangle.leftBottom());
			toggle(flags, rectangle.leftTop());
			toggle(flags, rectangle.rightBottom());
			toggle(flags, rectangle.rightTop());
		}

		Rectangle together = new Rectangle(left, bottom, right, top);

		return onlyContains(flags, together) ? (totalArea == together.area()) : false;
	}

	private boolean onlyContains(Set<Point> set, Rectangle rectangle) {
		return set.size() == 4 && contains(set, rectangle);
	}

	private boolean contains(Set<Point> set, Rectangle rectangle) {
		if (!set.contains(rectangle.leftBottom()))
			return false;
		if (!set.contains(rectangle.leftTop()))
			return false;
		if (!set.contains(rectangle.rightBottom()))
			return false;
		if (!set.contains(rectangle.rightTop()))
			return false;
		return true;
	}

}
