package org.dzhou.interview.scalability.socialnetwork;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ShortestPath {

	public LinkedList<Person> findPathBiBFS(HashMap<Integer, Person> people, int source,
			int destination) {
		BFSData sourceData = new BFSData(people.get(source));
		BFSData destData = new BFSData(people.get(destination));
		while (!sourceData.isFinished() && !destData.isFinished()) {
			Person collision = searchLevel(people, sourceData, destData);
			if (collision != null) {
				return mergePaths(sourceData, destData, collision.getPersonID());
			}
			collision = searchLevel(people, destData, sourceData);
			if (collision != null) {
				return mergePaths(sourceData, destData, collision.getPersonID());
			}
		}

		return null;
	}

	public Person searchLevel(HashMap<Integer, Person> people, BFSData primary, BFSData secondary) {
		int count = primary.toVisit.size();
		for (int i = 0; i < count; i++) {
			PathNode pathNode = primary.toVisit.poll();
			int personId = pathNode.getPerson().getPersonID();
			if (secondary.visited.containsKey(personId)) {
				return pathNode.getPerson();
			}
			Person person = pathNode.getPerson();
			List<Integer> friends = person.getFriends();
			for (int friendId : friends) {
				if (!primary.visited.containsKey(friendId)) {
					Person friend = people.get(friendId);
					PathNode next = new PathNode(friend, pathNode);
					primary.visited.put(friendId, next);
					primary.toVisit.add(next);
				}
			}
		}
		return null;
	}

	private LinkedList<Person> mergePaths(BFSData sourceData, BFSData destData, int id) {
		// TODO mergePaths
		return null;
	}

}
