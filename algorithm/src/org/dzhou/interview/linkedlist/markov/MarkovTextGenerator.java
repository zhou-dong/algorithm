package org.dzhou.interview.linkedlist.markov;

import java.util.List;

public interface MarkovTextGenerator {

	public class WordNode {
		private String word;
		private List<String> nextWords;

		public void addNextWord(String nextWord) {
			nextWords.add(nextWord);
		}

		public String getWord() {
			return word;
		}

		public String getRandomNextWord() {

			return null;
		}
	}

	public void train(String context);

	public void retrain(String context);

	public List<WordNode> generateText(int index);

}
