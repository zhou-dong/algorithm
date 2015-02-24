package org.dzhou.research.algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度搜索更加适用于所有边权重相同的情况。
 * 
 * @author DONG ZHOU
 *
 */
public class LessTransferBreadthFirst {

	private int max = Integer.MAX_VALUE;
	private int[] row0 = { 0, 1, 1, max, max };
	private int[] row1 = { 1, 0, 1, 1, max };
	private int[] row2 = { 1, 1, 0, 1, 1 };
	private int[] row3 = { max, 1, 1, 0, 1 };
	private int[] row4 = { max, max, 1, 1, 0 };
	private int[][] map = { row0, row1, row2, row3, row4 };
	private int[] book = { 0, 0, 0, 0, 0 };

	private boolean arrived = false;
	private int aim;

	public Queue<Note> queue = new LinkedList<>();

	public LessTransferBreadthFirst(int aim) {
		this.aim = aim;
	}

	public class Note {
		public int num;
		public int count;

		public Note(int num, int count) {
			this.num = num;
			this.count = count;
		}
	}

	public void execute() {
		queue.add(new Note(0, 0));
		while (queue.isEmpty() == false) {
			Note current = queue.peek();
			for (int i = 0; i < map.length; i++) {
				if (isArrived(i)) {
					arrived = true;
					break;
				}
				if (isInvalid(current.num, i))
					continue;
				if (isBooked(current.num))
					continue;
				if (isSelf(current.num, i))
					continue;
				book(i);
				queue.add(new Note(i, current.count + 1));
			}
			if (arrived)
				break;
			queue.remove();
		}

	}

	private boolean isBooked(int input) {
		return book[input] == 1;
	}

	private boolean isSelf(int nextRow, int nextCol) {
		return map[nextRow][nextCol] == 0;
	}

	private boolean isInvalid(int nextRow, int nextCol) {
		return map[nextRow][nextCol] == max;
	}

	private void book(int input) {
		book[input] = 1;
	}

	private boolean isArrived(int current) {
		return current == aim;
	}

	public static void main(String[] ars) {
		LessTransferBreadthFirst instance = new LessTransferBreadthFirst(4);
		instance.execute();
		for (Note note : instance.queue)
			System.out.println(note.count);
	}

}