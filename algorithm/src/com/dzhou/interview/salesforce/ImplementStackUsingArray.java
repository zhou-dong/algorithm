package com.dzhou.interview.salesforce;

public class ImplementStackUsingArray {

	public static void main(String[] args) {
		Stack stack = new Stack(10);
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}
		for (int i = 0; i < 10; i++) {
			int t = stack.pop();
			System.out.print(t + " ");
		}
		System.out.println();
		System.out.println("~~~~~~~~~~~~~");
		for (int i = 0; i < 20; i++) {
			stack.push(i);
		}
		for (int i = 0; i < 10; i++) {
			int t = stack.pop();
			System.out.print(t + " ");
		}
		for (int i = 0; i < 5; i++) {
			int t = stack.pop();
			System.out.print(t + " ");
		}
		System.out.println();
		System.out.println(stack.size);
		System.out.println(stack.array.length);
	}

	static class Stack {
		int size = 0;
		int defaultSize;
		int[] array;

		public Stack(int defaultSize) {
			this.array = new int[defaultSize];
			this.defaultSize = defaultSize;
		}

		public void push(int value) {
			expend();
			array[size] = value;
			size++;
		}

		private void expend() {
			if (size < array.length) {
				return;
			}
			int[] expend = new int[size * 2];
			copy(array, expend);
			array = expend;
		}

		private void copy(int[] target, int[] aim) {
			for (int i = 0; i < target.length; i++) {
				aim[i] = target[i];
			}
		}

		public int peek() {
			return array[size - 1];
		}

		public int pop() {
			int value = array[size - 1];
			array[size - 1] = 0;
			size--;
			toShort();
			return value;
		}

		public boolean isEmpty() {
			return size == 0;
		}

		private void toShort() {
			while (array.length > size * 2 && array.length > defaultSize) {
				int[] shorter = new int[array.length / 2];
				copy(shorter, array);
				array = shorter;
			}
		}

	}

}
