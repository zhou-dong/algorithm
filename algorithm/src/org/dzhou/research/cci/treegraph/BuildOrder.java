package org.dzhou.research.cci.treegraph;

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

	class Graph {
		private List<Project> nodes = new ArrayList<>();
		private Map<String, Project> map = new HashMap<>();

		public Project getOrCreateNode(String name) {
			if (!map.containsKey(name)) {
				Project node = new Project(name);
				nodes.add(node);
				map.put(name, node);
			}
			return map.get(name);
		}

		public void addEdge(String startName, String endName) {
			getOrCreateNode(startName).addNeighbor(getOrCreateNode(endName));
		}

		public List<Project> getNodes() {
			return this.nodes;
		}
	}

	public class Project {
		private List<Project> children = new ArrayList<>();
		private Map<String, Project> map = new HashMap<>();
		private String name;
		private int dependencies = 0;

		public void addNeighbor(Project node) {
			if (!map.containsKey(node.getName())) {
				children.add(node);
				node.incrementDependencies();
			}
		}

		public Project(String name) {
			this.name = name;
		}

		public void incrementDependencies() {
			this.dependencies++;
		}

		public void decrementDependencies() {
			this.dependencies--;
		}

		public String getName() {
			return this.name;
		}

		public List<Project> getChildren() {
			return this.children;
		}

		public int geNumberDependencies() {
			return this.dependencies;
		}
	}

	Graph buildGraph(String[] projects, String[][] dependencies) {
		Graph graph = new Graph();
		for (String project : projects) {
			graph.getOrCreateNode(project);
		}
		for (String[] dependency : dependencies) {
			graph.addEdge(dependency[0], dependency[1]);
		}
		return graph;
	}

	public class Solution {
		Project[] findBuildOrder(String[] projects, String[][] dependencies) {
			Graph graph = buildGraph(projects, dependencies);
			return orderProjects(graph.getNodes());
		}

		Project[] orderProjects(List<Project> projects) {
			Project[] order = new Project[projects.size()];
			int endOfList = addNonDependent(order, projects, 0);
			int toBeProcessed = 0;
			while (toBeProcessed < order.length) {
				Project current = order[toBeProcessed];
				if (current == null) {
					return null;
				}
				List<Project> children = current.getChildren();
				for (Project child : children) {
					child.decrementDependencies();
				}
				endOfList = addNonDependent(order, children, endOfList);
				toBeProcessed++;
			}
			return order;
		}

		int addNonDependent(Project[] order, List<Project> projects, int offset) {
			for (Project project : projects) {
				if (project.geNumberDependencies() == 0) {
					order[offset++] = project;
				}
			}
			return offset;
		}
	}

	public class Solution1 {

	}

}
