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

	/**
	 * 对于二叉树，我们把空的地方也作为叶子节点（如题目中的#），那么有
	 *
	 * - 所有的非空节点提供2个出度和1个入度（根除外） <br>
	 * - 所有的空节点但提供0个出度和1个入度 <br>
	 * 
	 * 我们在遍历的时候，计算diff=outdegree–indegree.当一个节点出现的时候,diff–1，因为它提供一个入度；当节点不是#的时候，
	 * diff+2(提供两个出度) 如果序列式合法的，那么遍历过程中diff >=0 且最后结果为0.
	 */
	public class Solution1 {

		public boolean isValidSerialization(String preorder) {
			String[] nodes = preorder.split(",");
			int diff = 1;
			for (String node : nodes) {
				if (--diff < 0)
					return false;
				if (!node.equals("#"))
					diff += 2;
			}
			return diff == 0;
		}

	}

}
