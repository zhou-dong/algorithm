package org.dzhou.practice.medium;

import java.util.Stack;

/**
 * 331. Verify Preorder Serialization of a Binary Tree
 * 
 * One way to serialize a binary tree is to use pre-order traversal. When we
 * encounter a non-null node, we record the node's value. If it is a null node,
 * we record using a sentinel value such as #.
 * 
 * ------_9_ <br>
 * -----/---\ <br>
 * ----3-----2 <br>
 * ---/-\---/-\ <br>
 * --4---1-#---6 <br>
 * -/-\-/-\---/-\ <br>
 * #---##--#-#---# <br>
 * 
 * For example, the above binary tree can be serialized to the string
 * "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.
 * 
 * Given a string of comma separated values, verify whether it is a correct
 * preorder traversal serialization of a binary tree. Find an algorithm without
 * reconstructing the tree.
 * 
 * Each comma separated value in the string must be either an integer or a
 * character '#' representing null pointer.
 * 
 * You may assume that the input format is always valid, for example it could
 * never contain two consecutive commas such as "1,,3".
 * 
 * Example 1: <br>
 * "9,3,4,#,#,1,#,#,2,#,6,#,#" <br>
 * Return true
 * 
 * Example 2: <br>
 * "1,#" <br>
 * Return false
 * 
 * Example 3: <br>
 * "9,#,#,1" <br>
 * Return false
 * 
 * reference:
 * 
 * https://www.hrwhisper.me/leetcode-verify-preorder-serialization-of-a-binary-
 * tree/
 * 
 * @author zhoudong
 */
public class VerifyPreorderSerializationOfABinaryTree {

	public static void main(String[] args) {
		new VerifyPreorderSerializationOfABinaryTree().test();
	}

	void test() {
		String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
		boolean t = new Solution().isValidSerialization(preorder);
		System.out.println(t);
	}

	// 栈: 这个方法简单的说就是不断的砍掉叶子节点。最后看看能不能全部砍掉。
	public class Solution {

		public boolean isValidSerialization(String preorder) {
			String[] nodes = preorder.split(",");
			Stack<String> stack = new Stack<>();
			for (String node : nodes) {
				if (!isNull(node)) {
					stack.push(node);
				} else if (!addNullToStack(stack)) {
					return false;
				}
			}
			return stack.size() == 1 && "#".equals(stack.peek());
		}

		private boolean addNullToStack(Stack<String> stack) {
			if (stack.isEmpty()) {
				stack.add("#");
				return true;
			} else if (!isNull(stack.peek())) {
				stack.push("#");
				return true;
			} else {
				stack.pop();
				if (stack.isEmpty() || isNull(stack.pop())) {
					return false;
				}
				return addNullToStack(stack);
			}
		}

		private boolean isNull(String node) {
			return "#".equals(node);
		}
	}
}
