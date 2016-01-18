package org.dzhou.interview.treeandgraph.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.function.Consumer;

/**
 * @author UCSD MOOC development team and YOU
 * 
 *         A class which represents a graph of geographic locations Nodes in the
 *         graph are intersections between
 *
 *         Copy for study!
 */
public class MapGraph {

	private int numEdges;
	private Map<GeographicPoint, Vertex> vertices;

	public MapGraph() {
		vertices = new HashMap<>();
	}

	public int getNumVertices() {
		return vertices.size();
	}

	public Set<GeographicPoint> getVertices() {
		return vertices.keySet();
	}

	public int getNumEdges() {
		return numEdges;
	}

	public boolean addVertex(GeographicPoint location) {
		if (location == null || vertices.containsKey(location))
			return false;
		return vertices.put(location, new Vertex(location)) != null;
	}

	public void addEdge(GeographicPoint from, GeographicPoint to, String roadName, String roadType,
			double length) throws IllegalArgumentException {
		if (isNullOrInVertices(from) || isNullOrInVertices(to) || Objects.isNull(roadName)
				|| Objects.isNull(roadType) || length < 0)
			throw new IllegalArgumentException();
		Edge edge = new Edge(from, to, roadName, roadType, length);
		vertices.get(from).getEdges().add(edge);
		numEdges++;
	}

	private boolean isNullOrInVertices(GeographicPoint vertex) {
		if (Objects.isNull(vertex) || !vertices.containsKey(vertex))
			return true;
		return false;
	}

	public List<GeographicPoint> bfs(GeographicPoint start, GeographicPoint goal) {
		Consumer<GeographicPoint> temp = (x) -> {
		};
		return bfs(start, goal, temp);
	}

	public List<GeographicPoint> bfs(GeographicPoint start, GeographicPoint goal,
			Consumer<GeographicPoint> nodeSearched) {
		Map<GeographicPoint, GeographicPoint> parent = bfsSearch(start, goal, nodeSearched);

		if (parent.isEmpty())
			return null;

		return generatePath(start, goal, parent);
	}

	private Map<GeographicPoint, GeographicPoint> bfsSearch(GeographicPoint start,
			GeographicPoint goal, Consumer<GeographicPoint> nodeSearched) {
		if (start == null || goal == null)
			return Collections.emptyMap();

		Map<GeographicPoint, GeographicPoint> parent = new HashMap<>();
		Set<GeographicPoint> visited = new HashSet<>();
		Queue<GeographicPoint> toExplore = new LinkedList<>();
		toExplore.add(start);
		visited.add(start);
		nodeSearched.accept(start);

		while (!toExplore.isEmpty()) {
			GeographicPoint current = toExplore.poll();
			if (current.distance(goal) == 0d)
				return parent;
			for (Edge e : vertices.get(current).getEdges()) {
				GeographicPoint next = e.getEnd();
				if (visited.contains(next))
					continue;
				visited.add(next);
				toExplore.add(next);
				parent.put(next, current);
				nodeSearched.accept(next);
			}
		}

		return Collections.emptyMap();
	}

	private List<GeographicPoint> generatePath(GeographicPoint start, GeographicPoint goal,
			Map<GeographicPoint, GeographicPoint> parent) {
		LinkedList<GeographicPoint> path = new LinkedList<>();
		GeographicPoint current = goal;
		while (current != start) {
			path.addFirst(current);
			current = parent.get(current);
		}
		path.addFirst(current);
		return path;
	}

	public List<GeographicPoint> dijkstra(GeographicPoint start, GeographicPoint goal) {
		Consumer<GeographicPoint> temp = (x) -> {
		};
		return dijkstra(start, goal, temp);
	}

	public List<GeographicPoint> dijkstra(GeographicPoint start, GeographicPoint goal,
			Consumer<GeographicPoint> nodeSearched) {
		initialDistanceToStart(start);

		Queue<Vertex> queue = new PriorityQueue<>();
		queue.add(vertices.get(start));
		Set<Vertex> visited = new HashSet<>();
		Map<GeographicPoint, GeographicPoint> parent = new HashMap<>();

		while (!queue.isEmpty()) {
			Vertex current = queue.poll();
			if (visited.contains(current))
				continue;
			visited.add(current);
			if (current.equals(vertices.get(goal)))
				break;
			for (Edge edge : current.getEdges()) {
				Vertex neighbor = vertices.get(edge.getEnd());
				if (visited.contains(neighbor))
					continue;
				double distance = edge.getDistance() + current.getDistance();
				if (neighbor.getDistance() > distance) {
					neighbor.setDistance(distance);
					parent.put(neighbor.getLocation(), current.getLocation());
				}
				queue.add(neighbor);
			}
		}

		if (parent.size() == 0)
			return Collections.emptyList();

		System.out.println(parent.size());

		return generatePath2(start, goal, parent);
	}

	private List<GeographicPoint> generatePath2(GeographicPoint start, GeographicPoint goal,
			Map<GeographicPoint, GeographicPoint> parent) {
		LinkedList<GeographicPoint> path = new LinkedList<>();
		GeographicPoint current = goal;
		while (current != null || current != start) {
			if (current == null)
				break;
			path.addFirst(current);
			current = parent.get(current);
		}
		path.addFirst(start);
		return path;
	}

	private void initialDistanceToStart(GeographicPoint start) {
		// initial start distance to 0
		Vertex startVertex = vertices.get(start);
		startVertex.setActualDistance(0d);
		startVertex.setDistance(0d);
		// contain start neighbors
		Set<GeographicPoint> visited = new HashSet<>();
		visited.add(start);
		// initial start neighbors' distance
		for (Edge edge : startVertex.getEdges()) {
			if (!edge.getStart().equals(start))
				continue;
			GeographicPoint neighbor = edge.getEnd();
			double distance = edge.getDistance();
			vertices.get(neighbor).setActualDistance(distance);
			vertices.get(neighbor).setDistance(distance);
			visited.add(neighbor);
		}
		// initial not neighbors' distance
		for (Entry<GeographicPoint, Vertex> entry : vertices.entrySet()) {
			if (visited.contains(entry.getKey()))
				continue;
			entry.getValue().setActualDistance(Double.MAX_VALUE);
			entry.getValue().setDistance(Double.MAX_VALUE);
		}
	}

	public List<GeographicPoint> aStarSearch(GeographicPoint start, GeographicPoint goal) {
		Consumer<GeographicPoint> temp = (x) -> {
		};
		return aStarSearch(start, goal, temp);
	}

	public List<GeographicPoint> aStarSearch(GeographicPoint start, GeographicPoint goal,
			Consumer<GeographicPoint> nodeSearched) {

		initialDistanceToStart(start);
		initialDistanceToGoal(goal);

		Queue<Vertex> queue = new PriorityQueue<>();
		queue.add(vertices.get(start));
		Set<Vertex> visited = new HashSet<>();
		Map<GeographicPoint, GeographicPoint> parent = new HashMap<>();

		while (!queue.isEmpty()) {
			Vertex current = queue.poll();
			if (current == vertices.get(goal))
				break;
			if (visited.contains(current))
				continue;
			visited.add(current);
			for (Edge edge : current.getEdges()) {
				Vertex neighbor = vertices.get(edge.getEnd());
				if (visited.contains(neighbor))
					continue;
				double distance = edge.getDistance() + current.getDistance();

				if (neighbor.getDistance() > distance) {
					neighbor.setDistance(distance);
					parent.put(neighbor.getLocation(), current.getLocation());
				}
				queue.add(neighbor);
			}
		}

		if (parent.size() == 0)
			return Collections.emptyList();

		return generatePath2(start, goal, parent);
	}

	private void initialDistanceToGoal(GeographicPoint goal) {
		for (Entry<GeographicPoint, Vertex> entry : vertices.entrySet()) {
			Vertex vertex = entry.getValue();
			double distance = Double.MAX_VALUE;
			for (Edge edge : vertex.getEdges()) {
				if (goal.equals(edge.getEnd())) {
					distance = edge.getDistance();
					break;
				}
			}
			vertex.setActualDistance(distance);
		}
	}

}
