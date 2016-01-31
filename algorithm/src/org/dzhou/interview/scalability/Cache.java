package org.dzhou.interview.scalability;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 */
public class Cache {

	class Node {
		String query;
		String[] results;

		public Node(String query, String[] results) {
			this.query = query;
			this.results = results;
		}
	}

	public Cache() {
		map = new HashMap<>();
		nodes = new LinkedList<>();
	}

	public static int MAX_SIZE = 10;
	public LinkedList<Node> nodes;
	public int size = 0;
	public Map<String, Node> map;

	public void moveToFront(Node node) {
		nodes.remove(node);
		nodes.addFirst(node);
	}

	public void insertResults(String query, String[] results) {
		if (map.containsKey(query)) {
			Node node = map.get(query);
			node.results = results;
			moveToFront(node);
			return;
		}
		Node node = new Node(query, results);
		moveToFront(node);
		map.put(query, node);
		if (map.size() > MAX_SIZE) {
			map.remove(nodes.getLast().query);
			nodes.remove(node);
		}
	}

}
