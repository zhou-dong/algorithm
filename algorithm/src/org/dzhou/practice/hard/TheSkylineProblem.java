package org.dzhou.practice.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * @author zhoudong
 *
 */
public class TheSkylineProblem {

	// reference:
	// http://www.programcreek.com/2014/06/leetcode-the-skyline-problem-java/
	public class Solution {

		abstract class Edge {
			protected int x;
			protected int height;

			abstract boolean isStart();

			public Edge(int x, int height) {
				this.x = x;
				this.height = height;
			}
		}

		class Start extends Edge {
			public Start(int x, int height) {
				super(x, height);
			}

			@Override
			boolean isStart() {
				return true;
			}
		}

		class End extends Edge {
			public End(int x, int height) {
				super(x, height);
			}

			@Override
			boolean isStart() {
				return false;
			}
		}

		private List<Edge> getEdges(int[][] buildings) {
			List<Edge> edges = new ArrayList<Edge>();
			for (int[] building : buildings) {
				edges.add(new Start(building[0], building[2]));
				edges.add(new End(building[1], building[2]));
			}
			return edges;
		}

		private void sortEdges(List<Edge> edges) {
			Collections.sort(edges, new Comparator<Edge>() {
				public int compare(Edge a, Edge b) {
					if (a.x != b.x)
						return Integer.compare(a.x, b.x);
					if (a.isStart() && b.isStart())
						return Integer.compare(b.height, a.height);
					if (!a.isStart() && !b.isStart())
						return Integer.compare(a.height, b.height);
					return a.isStart() ? -1 : 1;
				}
			});
		}

		private List<int[]> execute(List<Edge> edges) {
			PriorityQueue<Integer> heightHeap = new PriorityQueue<Integer>(10, Collections.reverseOrder());

			List<int[]> result = new ArrayList<int[]>();
			for (Edge edge : edges) {
				if (edge.isStart()) {
					if (heightHeap.isEmpty() || edge.height > heightHeap.peek()) {
						result.add(new int[] { edge.x, edge.height });
					}
					heightHeap.add(edge.height);
				} else {
					heightHeap.remove(edge.height);
					if (heightHeap.isEmpty()) {
						result.add(new int[] { edge.x, 0 });
					} else if (edge.height > heightHeap.peek()) {
						result.add(new int[] { edge.x, heightHeap.peek() });
					}
				}
			}

			return result;
		}

		public List<int[]> getSkyline(int[][] buildings) {
			if (buildings == null || buildings.length == 0 || buildings[0].length == 0)
				return Collections.emptyList();
			List<Edge> edges = getEdges(buildings);
			sortEdges(edges);
			return execute(edges);
		}
	}

}
