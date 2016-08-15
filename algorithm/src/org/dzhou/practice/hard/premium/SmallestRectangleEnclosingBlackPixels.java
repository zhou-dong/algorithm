package org.dzhou.practice.hard.premium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * An image is represented by a binary matrix with 0 as a white pixel and 1 as a
 * black pixel. The black pixels are connected, i.e., there is only one black
 * region. Pixels are connected horizontally and vertically. Given the location
 * (x, y) of one of the black pixels, return the area of the smallest
 * (axis-aligned) rectangle that encloses all black pixels.
 * 
 * For example, given the following image:
 * 
 * [ <br>
 * "0010", <br>
 * "0110", <br>
 * "0100" <br>
 * ] <br>
 * and x = 0, y = 2, <br>
 * Return 6.
 * 
 * @author zhoudong
 *
 */
public class SmallestRectangleEnclosingBlackPixels {

	public static void main(String[] args) {
		new SmallestRectangleEnclosingBlackPixels().test();
	}

	void test() {
		char[] one = new char[] { '0', '0', '1', '0' };
		char[] two = new char[] { '0', '1', '1', '0' };
		char[] thr = new char[] { '1', '1', '0', '0' };
		int area = new Solution().minArea(new char[][] { one, two, thr }, 0, 2);
		System.out.println(area);
	}

	public class Solution {
		public int minArea(char[][] image, int x, int y) {
			if (image == null || image.length == 0) {
				return 0;
			}
			int rowNum = image.length, colNum = image[0].length;
			int left = binarySearch(image, 0, y, 0, rowNum, true, true);
			int right = binarySearch(image, y + 1, colNum, 0, rowNum, true, false);
			int top = binarySearch(image, 0, x, left, right, false, true);
			int bot = binarySearch(image, x + 1, rowNum, left, right, false, false);

			return (right - left) * (bot - top);
		}

		private int binarySearch(char[][] image, int lo, int hi, int min, int max, boolean searchHorizontal,
				boolean searchLo) {
			while (lo < hi) {
				int mid = lo + (hi - lo) / 2;
				boolean hasBlackPixel = false;
				for (int i = min; i < max; i++) {
					if ((searchHorizontal ? image[i][mid] : image[mid][i]) == '1') {
						hasBlackPixel = true;
						break;
					}
				}
				if (hasBlackPixel == searchLo) {
					hi = mid;
				} else {
					lo = mid + 1;
				}
			}
			return lo;
		}

	}

	// Time Limit Exceeded
	public class Solution1 {
		class Point {
			int row;
			int col;

			Point(int row, int col) {
				this.row = row;
				this.col = col;
			}
		}

		public int minArea(char[][] image, int x, int y) {
			int top = x, bottom = x;
			int left = y, right = y;
			Queue<Point> queue = new LinkedList<>();
			queue.add(new Point(x, y));
			while (!queue.isEmpty()) {
				Point current = queue.poll();
				image[current.row][current.col] = 0;
				top = Math.min(top, current.row);
				bottom = Math.max(bottom, current.row);
				left = Math.min(left, current.col);
				right = Math.max(right, current.col);
				addPointToQueue(queue, image, new Point(current.row - 1, current.col));
				addPointToQueue(queue, image, new Point(current.row + 1, current.col));
				addPointToQueue(queue, image, new Point(current.row, current.col - 1));
				addPointToQueue(queue, image, new Point(current.row, current.col + 1));
			}
			return (right - left + 1) * (bottom - top + 1);
		}

		private void addPointToQueue(Queue<Point> queue, char[][] image, Point point) {
			if (isValid(image, point)) {
				queue.add(point);
			}
		}

		private boolean isValid(char[][] image, Point point) {
			return isValid(image, point.row, point.col);
		}

		private boolean isValid(char[][] image, int row, int col) {
			if (row < 0 || col < 0 || row >= image.length || col >= image[row].length)
				return false;
			return image[row][col] == '1';
		}
	}

}
