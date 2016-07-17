package org.dzhou.research.cci.treegraph;

/**
 * Practice of "cracking the code interview"
 * 
 * Design an algorithm and write code find the first common ancestor of two
 * nodes in binary tree. Avoid storing additional nodes in a data structure.
 * NOTE: This is not necessarily a binary search tree.
 * 
 * @author DONG ZHOU
 */
public class FirstCommonAncestor {

	class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;
		TreeNode parent;

		TreeNode(int value) {
			this.value = value;
		}
	}

	boolean covers(TreeNode root, TreeNode node) {
		if (root == null)
			return false;
		if (root == node)
			return true;
		return covers(root.left, node) || covers(root.right, node);
	}

	// Solution 1: With links to parents
	public class Solution {
		TreeNode commonAncestor(TreeNode p, TreeNode q) {
			int delta = depth(p) - depth(q);
			TreeNode shorter = delta > 0 ? q : p;
			TreeNode longer = delta > 0 ? p : q;
			longer = goUpBy(longer, Math.abs(delta));
			while (shorter != null && longer != null && shorter != longer) {
				shorter = shorter.parent;
				longer = longer.parent;
			}
			return shorter;
		}

		private TreeNode goUpBy(TreeNode node, int delta) {
			for (int i = 0; i < delta && node != null; i++) {
				node = node.parent;
			}
			return node;
		}

		private int depth(TreeNode node) {
			int depth = 0;
			while (node != null) {
				depth++;
				node = node.parent;
			}
			return depth;
		}
	}

	// Solution 2: With links to parents
	public class Solution2 {
		TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
			if (!covers(root, p) || !covers(root, q))
				return null;
			else if (covers(p, q))
				return p;
			else if (covers(q, p))
				return q;
			TreeNode sibling = getSibling(p);
			TreeNode parent = p.parent;
			while (!covers(sibling, q)) {
				sibling = getSibling(parent);
				parent = parent.parent;
			}
			return parent;
		}

		TreeNode getSibling(TreeNode node) {
			if (node == null || node.parent == null)
				return null;
			TreeNode parent = node.parent;
			return parent.left == node ? node.right : node.left;
		}
	}

	// Solution 3: Without links to parent
	public class Solution3 {
		TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
			if (!covers(root, p) || !covers(root, q))
				return null;
			return ancestorHelper(root, p, q);
		}

		TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q) {
			if (root == null || root == p || root == q)
				return root;
			boolean pIsOnLeft = covers(root.left, p);
			boolean qIsOnLeft = covers(root.left, p);
			if (pIsOnLeft != qIsOnLeft) // nodes are on different side
				return root;
			TreeNode childSide = pIsOnLeft ? root.left : root.right;
			return ancestorHelper(childSide, p, q);
		}
	}

	// Solution 4: optimized solution 3
	public class Solution4 {
		class Result {
			TreeNode node;
			boolean isAncestor;

			Result(TreeNode node, boolean isAncestor) {
				this.node = node;
				this.isAncestor = isAncestor;
			}
		}

		TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
			Result result = commonAncestorHelper(root, p, q);
			if (result.isAncestor)
				return result.node;
			return null;
		}

		Result commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
			if (root == null)
				return new Result(null, false);
			if (root == p || root == q)
				return new Result(root, true);
			Result rx = commonAncestorHelper(root.left, p, q);
			if (rx.isAncestor)
				return rx;
			Result ry = commonAncestorHelper(root.right, p, q);
			if (ry.isAncestor)
				return ry;
			if (rx.node != null && ry.node != null)
				return new Result(root, true);
			else if (root == p || root == q) {
				boolean isAncestor = rx.node != null || ry.node != null;
				return new Result(root, isAncestor);
			} else {
				return new Result(rx.node != null ? rx.node : ry.node, false);
			}
		}
	}

}
