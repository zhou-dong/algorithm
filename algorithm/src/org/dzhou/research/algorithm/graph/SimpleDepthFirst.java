package org.dzhou.research.algorithm.graph;

/** how many combination of putting numbers into boxes */
public class SimpleDepthFirst {

	private int max;
	private int[] nums;
	private int[] book;

	public SimpleDepthFirst(int max) {
		this.max = max;
		this.nums = new int[max];
		this.book = new int[max];
	}

	public void execute(int step) {
		if (step == max) {
			for (int i : nums)
				System.out.print(i + " ");
			System.out.println("");
			return;
		}
		for (int i = 0; i < max; i++) {
			if (book[i] == 0) {
				nums[step] = i;
				book[i] = 1;
				execute(step + 1);
				book[i] = 0;
			}
		}
	}

	public static void main(String args[]) {
		(new SimpleDepthFirst(3)).execute(0);
	}

}