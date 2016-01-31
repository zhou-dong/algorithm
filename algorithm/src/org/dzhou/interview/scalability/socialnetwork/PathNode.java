package org.dzhou.interview.scalability.socialnetwork;

import java.util.LinkedList;

public class PathNode {

	private Person person = null;
	private PathNode previousNode = null;

	public PathNode(Person person, PathNode previous) {
		this.person = person;
		this.previousNode = previous;
	}

	public LinkedList<Person> collapse(boolean startsWithRoot) {
		LinkedList<Person> path = new LinkedList<>();
		PathNode node = this;
		while (node != null) {
			if (startsWithRoot) {
				path.addLast(node.person);
			} else {
				path.addFirst(node.person);
			}
			node = node.previousNode;
		}
		return path;
	}

	public Person getPerson() {
		return person;
	}

	public PathNode getPreviousNode() {
		return previousNode;
	}

}
