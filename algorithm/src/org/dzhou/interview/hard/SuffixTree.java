package org.dzhou.interview.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 *         给定一个字符串s和一个包含较短字符串的数组T，设计一个方法，根据T中的每一个较短字符串，对s进行搜索。
 */
public class SuffixTree {

	TreeNode root;

	class TreeNode {
		HashMap<Character, TreeNode> children;
		String text;
		boolean isWord;
		List<Integer> indexes;

		public TreeNode() {
			children = new HashMap<>();
			indexes = new ArrayList<>();
		}

		public void insertString(String s, int index) {
		}

		public List<Integer> search(String s) {
			return null;
		}
	}

}
