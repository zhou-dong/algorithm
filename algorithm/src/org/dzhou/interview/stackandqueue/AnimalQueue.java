package org.dzhou.interview.stackandqueue;

import java.util.LinkedList;

/**
 * Practice of "cracking the code interview"
 * 
 * An animal shelter holds only dogs and cats, and operates on a strictly “first
 * in, first out” basis. People must adopt either the “oldest” (based on arrival
 * time) of all animals at the shelter, or they can select whether they would
 * prefer a dog or a cat (and will receive the oldest animal of that type). They
 * cannot select which specific animal they would like. Create the data
 * structures to maintain this system and implement operations such as enqueue,
 * dequeueAny, dequeueDog and dequeueCat. You may use the built-in Linked List
 * data structure.
 * 
 * @author DONG ZHOU
 *
 */
public class AnimalQueue {

	LinkedList<Dog> dogs = new LinkedList<>();
	LinkedList<Cat> cats = new LinkedList<>();
	private int order = 0;

	public void enqueue(Animal animal) {
		animal.setOrder(order);
		order++;
		if (animal instanceof Dog)
			dogs.addLast((Dog) animal);
		else if (animal instanceof Cat)
			cats.addLast((Cat) animal);
	}

	public Animal dequeueAny() {
		if (dogs.size() == 0)
			return dequeueCats();
		else if (cats.size() == 0)
			return dequeueDogs();

		Dog dog = dogs.peek();
		Cat cat = cats.peek();

		if (dog.isOlderThan(cat))
			return dequeueDogs();
		else
			return dequeueCats();
	}

	public Dog dequeueDogs() {
		return dogs.poll();
	}

	public Cat dequeueCats() {
		return cats.poll();
	}
}

abstract class Animal {

	private int order;
	protected String name;

	public Animal(String name) {
		this.name = name;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public boolean isOlderThan(Animal animal) {
		return this.order < animal.getOrder();
	}

}

class Dog extends Animal {
	public Dog(String name) {
		super(name);
	}
}

class Cat extends Animal {
	public Cat(String name) {
		super(name);
	}
}