package org.dzhou.practice.medium.premium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 353. Design Snake Game
 * 
 * @author zhoudong
 * 
 *         wrong solution!!!
 */
public class DesignSnakeGame {

	public static void main(String[] args) {
		new DesignSnakeGame().test();
	}

	void test() {
		int width = 3, height = 3;
		int[][] food = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 2, 2 }, { 2, 1 }, { 2, 0 }, { 1, 0 } };
		SnakeGame game = new SnakeGame(width, height, food);
		String[] moves = { "R", "R", "D", "D", "L", "L", "U", "U", "R", "R", "D", "D", "L", "L", "U", "R", "U", "L",
				"D" };
		for (String move : moves)
			System.out.println(game.move(move));
	}

	public class SnakeGame {

		Map<String, int[]> directions;
		private boolean[][] snake;
		private boolean[][] foods;
		private LinkedList<int[]> body;
		private int[][] food;

		/**
		 * Initialize your data structure here.
		 * 
		 * @param width
		 *            - screen width
		 * @param height
		 *            - screen height
		 * @param food
		 *            - A list of food positions E.g food = [[1,1], [1,0]] means
		 *            the first food is positioned at [1,1], the second is at
		 *            [1,0].
		 */
		public SnakeGame(int width, int height, int[][] food) {
			body = new LinkedList<>();
			body.add(new int[] { 0, 0 });
			snake = new boolean[height][width];
			foods = new boolean[height][width];
			this.food = food;
			setFood(food);
			directions = directions();
		}

		/**
		 * Moves the snake.
		 * 
		 * @param direction
		 *            - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
		 * @return The game's score after the move. Return -1 if game over. Game
		 *         over when snake crosses the screen boundary or bites its
		 *         body.
		 */
		public int move(String direction) {
			int[] head = body.peekLast();
			int[] next = getNext(direction, head[0], head[1]);
			if (!isValid(next)) {
				return -1;
			}
			grow(next);
			if (hasFood(next)) {
				eatFood(next);
				setFood(food);
			} else {
				removeTail();
			}
			return body.size() - 1;
		}

		private void setFood(int[][] food) {
			int index = body.size() - 1;
			if (index < food.length) {
				setFood(food, index);
			}
		}

		private void setFood(int[][] food, int index) {
			foods[food[index][0]][food[index][1]] = true;
		}

		private void removeTail() {
			int[] tail = body.pop();
			snake[tail[0]][tail[1]] = false;
		}

		private void grow(int[] next) {
			body.add(next);
			snake[next[0]][next[1]] = true;
		}

		private void eatFood(int[] location) {
			eatFood(location[0], location[1]);
		}

		private void eatFood(int row, int col) {
			foods[row][col] = false;
		}

		private boolean hasFood(int[] location) {
			return hasFood(location[0], location[1]);
		}

		private boolean hasFood(int row, int col) {
			return foods[row][col] == true;
		}

		private boolean isValid(int[] location) {
			return isValid(location[0], location[1]);
		}

		private boolean isValid(int row, int col) {
			if (row < 0 || col < 0 || row >= foods.length || col >= foods[0].length)
				return false;
			if (snake[row][col] == false)
				return true;
			int[] tail = body.peek();
			return tail[0] == row && tail[1] == col;
		}

		private int[] getNext(String direction, int row, int col) {
			int[] dir = directions.get(direction);
			return new int[] { row + dir[0], col + dir[1] };
		}

		private Map<String, int[]> directions() {
			Map<String, int[]> map = new HashMap<>();
			map.put("U", new int[] { -1, 0 });
			map.put("L", new int[] { 0, -1 });
			map.put("R", new int[] { 0, 1 });
			map.put("D", new int[] { 1, 0 });
			return map;
		}
	}

	// Your SnakeGame object will be instantiated and called as such:
	// SnakeGame obj = new SnakeGame(width, height, food);
	// int param_1 = obj.move(direction);
}