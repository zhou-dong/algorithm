package com.dzhou.interview.google;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ImplementStackUsingArray {

	public static class Stack {

		int[] array;
		int size;
		int capacity;
		int defaultSize = 10;

		Stack() {
		}

		Stack(int defaultSize) {
			this.defaultSize = defaultSize;
		}

		public void push(int value) {
			expend();
			array[size] = value;
			size++;
		}

		private void expend() {
			if (this.size < array.length)
				return;
			array = Arrays.copyOf(array, array.length * 2);
		}

		public int peek() {
			checkEmpty();
			return array[size - 1];
		}

		public int pop() {
			checkEmpty();
			int value = array[size - 1];
			size--;
			shorter();
			return value;
		}

		private void checkEmpty() {
			if (size == 0) {
				throw new EmptyStackException();
			}
		}

		private void shorter() {
			while (this.array.length > this.size * 2 && this.array.length > defaultSize * 2) {
				array = Arrays.copyOf(array, array.length / 2);
			}
		}

		public boolean isEmpty() {
			return this.size == 0;
		}

	}

}
