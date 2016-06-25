package org.dzhou.practice.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list
 * of its neighbors.
 * 
 * OJ's undirected graph serialization: Nodes are labeled uniquely.
 * 
 * We use # as a separator for each node, and , as a separator for node label
 * and each neighbor of the node. As an example, consider the serialized graph
 * {0,1,2#1,2#2,2}.
 * 
 * The graph has a total of three nodes, and therefore contains three parts as
 * separated by #.
 * 
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2. Second node
 * is labeled as 1. Connect node 1 to node 2. Third node is labeled as 2.
 * Connect node 2 to node 2 (itself), thus forming a self-cycle. Visually, the
 * graph looks like the following:
 * 
 * -------1<br>
 * ------/-\<br>
 * -----/---\<br>
 * ----0-----2<br>
 * ---------/-\<br>
 * ---------\_/<br>
 * 
 * @author zhoudong
 *
 *         reference from : http://www.jiuzhang.com/solutions/clone-graph/
 */
public class CloneGraph {

	// Definition for undirected graph.
	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}

	// BFS
	public class Solution {

		public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
			if (node == null)
				return null;
			// use bfs algorithm to traverse the graph and get all nodes.
			List<UndirectedGraphNode> nodes = getNodes(node);
			// copy nodes, store the old->new mapping information in a hash map
			Map<UndirectedGraphNode, UndirectedGraphNode> mapping = mappingNodesOld2New(nodes);
			// copy neighbors(edges)
			copyNeighbors(nodes, mapping);
			return mapping.get(node);
		}

		private void copyNeighbors(List<UndirectedGraphNode> nodes,
				Map<UndirectedGraphNode, UndirectedGraphNode> mapping) {
			for (UndirectedGraphNode n : nodes) {
				UndirectedGraphNode newNode = mapping.get(n);
				for (UndirectedGraphNode neighbor : n.neighbors) {
					UndirectedGraphNode newNeighbor = mapping.get(neighbor);
					newNode.neighbors.add(newNeighbor);
				}
			}
		}

		private Map<UndirectedGraphNode, UndirectedGraphNode> mappingNodesOld2New(List<UndirectedGraphNode> nodes) {
			Map<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
			for (UndirectedGraphNode n : nodes) {
				mapping.put(n, new UndirectedGraphNode(n.label));
			}
			return mapping;
		}

		private List<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
			Queue<UndirectedGraphNode> queue = new LinkedList<>();
			Set<UndirectedGraphNode> set = new HashSet<>();
			queue.add(node);
			set.add(node);
			while (!queue.isEmpty()) {
				UndirectedGraphNode current = queue.poll();
				for (UndirectedGraphNode neighbor : current.neighbors) {
					if (!set.contains(neighbor)) {
						queue.add(neighbor);
						set.add(neighbor);
					}
				}
			}
			return new ArrayList<>(set);
		}

	}

}
