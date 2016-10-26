package com.dzhou.interview.salesforce;

import java.util.Arrays;

public class ImplementStackUsingArray {

	public static class Stack {

		int[] array;
		int size;
		int defaultSize;
		int capacity;

		public Stack(int defaultSize) {
			this.defaultSize = defaultSize;
			array = new int[defaultSize];
			size = 0;
		}

		public void push(int value) {
			expend();
			array[size] = value;
			size++;
		}

		private void expend() {
			if (size < array.length)
				return;
			array = Arrays.copyOf(array, array.length * 2);
		}

		public int peek() {
			return array[size - 1];
		}

		public int pop() {
			int value = array[size - 1];
			array[size - 1] = 0;
			size--;
			shorter();
			return value;
		}

		private void shorter() {
			while (array.length >= 2 * defaultSize && array.length > 2 * size) {
				array = Arrays.copyOf(array, array.length / 2);
			}
		}

		public boolean isEmpty() {
			return size == 0;
		}

		public int size() {
			return size;
		}

		public int capacity() {
			return array.length;
		}
	}

}
