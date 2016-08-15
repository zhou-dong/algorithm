package org.dzhou.practice.medium.premium;

/**
 * 261. Graph Valid Tree
 * 
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each
 * edge is a pair of nodes), write a function to check whether these edges make
 * up a valid tree.
 * 
 * For example:
 * 
 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 * 
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return
 * false.
 * 
 * Hint:
 * 
 * 1.Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return?
 * Is this case a valid tree?
 * 
 * 2.According to the definition of tree on Wikipedia: “a tree is an undirected
 * graph in which any two vertices are connected by exactly one path. In other
 * words, any connected graph without simple cycles is a tree.” Note: you can
 * assume that no duplicate edges will appear in edges. Since all edges are
 * undirected, [0, 1] is the same as [1, 0] and thus will not appear together in
 * edges.
 * 
 * @author zhoudong
 *
 *         思路: <br>
 *         判断输入的边是否能构成一个树，我们需要确定两件事：<br>
 *         1.这些边是否构成环路，如果有环则不能构成树 <br>
 *         2.这些边是否能将所有节点连通，如果有不能连通的节点则不能构成树
 */
public class GraphValidTree {

	public class Solution {

		public boolean validTree(int n, int[][] edges) {
			if (n - 1 != edges.length) {
				return false;
			}
			UnionFind unionFind = new UnionFind(n);
			for (int[] edge : edges) {
				if (!unionFind.union(edge[0], edge[1])) {
					return false;
				}
			}
			return true;
		}

		public class UnionFind {
			private int[] roots;
			private int count;

			public UnionFind(int size) {
				this.roots = new int[size];
				for (int i = 0; i < size; i++)
					roots[i] = i;
				this.count = size;
			}

			public boolean union(int x, int y) {
				if (connected(x, y))
					return false;
				int rootY = roots[y];
				for (int i = 0; i < roots.length; i++) {
					if (roots[i] == y || roots[i] == rootY) {
						roots[i] = roots[x];
					}
				}
				count--;
				return true;
			}

			public boolean connected(int x, int y) {
				return roots[x] == roots[y];
			}

			public int count() {
				return count;
			}
		}

	}

}
