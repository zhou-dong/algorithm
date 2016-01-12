package org.dzhou.interview.linkedlist.markov;

import java.util.List;
import java.util.Random;

public class MarkovTextGenerator {

	public class WordNode {
		private String word;
		private List<String> nextWords;

		public void addNextWord(String nextWord) {
			nextWords.add(nextWord);
		}

		public String getWord() {
			return word;
		}

		public String getRandomNextWord(Random generator) {
			int index = generator.nextInt(nextWords.size());
			return nextWords.get(index);
		}
	}

	public void train(String context) {
	}

	public void retrain(String context) {
	}

	public String generateText(int numWords) {
		return "";
	}

	public static void main(String[] args) {
		Random generator = new Random();
		int size = 10;
		for (int i = 0; i < size * 4; i++) {
			System.out.println(generator.nextInt(size));
		}
	}

}
