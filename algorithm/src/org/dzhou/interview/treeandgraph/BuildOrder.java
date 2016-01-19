package org.dzhou.interview.treeandgraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Practice of "cracking the code interview"
 * 
 * You are given a list of projects and a list of dependencies (which is a list
 * of pairs of projects, where the first project is depend on the second
 * project). All of a project's dependencies must be built before the project
 * is. Find a build order that will allow the projects to be built. If there is
 * no valid build order, return an error.
 * 
 * @author DONG ZHOU
 *
 */
public class BuildOrder {

	public class Project {
		private String name;
		private int dependencies = 0;
		private List<Project> children = new ArrayList<>();
		private Map<String, Project> map = new HashMap<>();

		public void addNeighbor(Project node) {
			if (!map.containsKey(node.getName())) {
				children.add(node);
				map.put(node.getName(), node);
			}
			node.incrementDependencies();
		}

		public Project(String name) {
			this.name = name;
		}

		public void incrementDependencies() {
			dependencies++;
		}

		public void decrementDependencise() {
			dependencies--;
		}

		public String getName() {
			return this.name;
		}

		public List<Project> getChildren() {
			return this.children;
		}

		public int getDependencies() {
			return this.dependencies;
		}
	}

	public class Graph {
		private List<Project> nodes = new ArrayList<>();
		private HashMap<String, Project> map = new HashMap<>();

		public Project getOrCreateNode(String name) {
			if (!map.containsKey(name)) {
				Project node = new Project(name);
				nodes.add(node);
				map.put(name, node);
			}
			return map.get(name);
		}

		public void addEdge(String startName, String endName) {
			Project start = getOrCreateNode(startName);
			Project end = getOrCreateNode(endName);
			start.addNeighbor(end);
		}

		public List<Project> getNodes() {
			return this.nodes;
		}
	}

	int addNonDependent(Project[] order, List<Project> projects, int offset) {
		for (Project project : projects) {
			if (project.getDependencies() == 0) {
				order[offset] = project;
				offset++;
			}
		}
		return offset;
	}

	Graph buildGraph(String[] projects, String[][] dependencies) {
		Graph graph = new Graph();
		for (String[] dependency : dependencies)
			graph.addEdge(dependency[0], dependency[1]);
		return graph;
	}
}
