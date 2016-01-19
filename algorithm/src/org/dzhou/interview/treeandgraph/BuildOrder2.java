package org.dzhou.interview.treeandgraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.dzhou.interview.treeandgraph.BuildOrder2.Project.State;

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
 *         Use DFS to implement
 */
public class BuildOrder2 {

	public static class Project {

		public enum State {
			COMPLETE, PARTIAL, BLANK;
		}

		private State state;
		private String name;
		private Map<String, Project> map;
		private List<Project> children;

		public Project(String name) {
			this.name = name;
			setState(State.BLANK);
			map = new HashMap<>();
			children = new ArrayList<>();
		}

		public boolean addNeighbor(Project node) {
			if (map.containsKey(node.getName()))
				return false;
			map.put(node.getName(), node);
			children.add(node);
			return true;
		}

		public State getState() {
			return state;
		}

		public void setState(State state) {
			this.state = state;
		}

		public String getName() {
			return name;
		}

		public List<Project> getChildren() {
			return new ArrayList<>(children);
		}
	}

	public static class Graph {
		Map<String, Project> map = new HashMap<>();
		List<Project> nodes = new ArrayList<>();

		public List<Project> getNodes() {
			return new ArrayList<>(nodes);
		}

		public Project getOrCreateNode(String name) {
			if (!map.containsKey(name)) {
				Project node = new Project(name);
				map.put(name, node);
				nodes.add(node);
			}
			return map.get(name);
		}

		public void addEdge(String startName, String endName) {
			getOrCreateNode(startName).addNeighbor(getOrCreateNode(endName));
		}
	}

	Stack<Project> orderProjects(List<Project> projects) {
		Stack<Project> stack = new Stack<>();
		for (Project project : projects) {
			if (project.getState() == State.BLANK) {
				if (!doDFS(project, stack)) {
					return null;
				}
			}
		}
		return stack;
	}

	boolean doDFS(Project project, Stack<Project> stack) {
		if (project.getState() == State.PARTIAL)
			return false;
		if (project.getState() == State.BLANK) {
			project.setState(State.PARTIAL);
			List<Project> children = project.getChildren();
			for (Project child : children) {
				if (!doDFS(child, stack)) {
					return false;
				}
			}
			project.setState(State.COMPLETE);
			stack.push(project);
		}
		return true;
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

	Stack<Project> findBuildOrder(String[] projects, String[][] dependencies) {
		Graph graph = buildGraph(projects, dependencies);
		return orderProjects(graph.getNodes());
	}
}
