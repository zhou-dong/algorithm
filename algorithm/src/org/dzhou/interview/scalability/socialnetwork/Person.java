package org.dzhou.interview.scalability.socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class Person {

	private int personID;
	private String info;
	private List<Integer> friends = new ArrayList<Integer>();

	public Person(int id) {
		this.personID = id;
	}

	public void addFriend(int id) {
		friends.add(id);
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getPersonID() {
		return personID;
	}

	public List<Integer> getFriends() {
		return new ArrayList<>(friends);
	}

}
