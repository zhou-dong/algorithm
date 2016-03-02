package org.dzhou.interview.hard;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 *         有一个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离（也即相隔几个单词）。
 */
public class TwoWordDistance {

	public int shortest(String[] words, String word1, String word2) {
		int min = Integer.MAX_VALUE;
		int lastPosWord1 = -1;
		int lastPosWord2 = -1;
		for (int i = 0; i < words.length; i++) {
			String current = words[i];
			if (current.equals(word1)) {
				lastPosWord1 = i;
				int distance = lastPosWord1 - lastPosWord2;
				if (lastPosWord2 >= 0 && min > distance) {
					min = distance;
				}
			} else if (current.equals(word2)) {
				lastPosWord2 = i;
				int distance = lastPosWord2 - lastPosWord1;
				if (lastPosWord1 >= 0 && min > distance) {
					min = distance;
				}
			}
		}
		return min;
	}

}
