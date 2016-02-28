package org.dzhou.interview.moderate;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 */
public class BiLink {

	public class BiNode {
		public int value;
		public BiNode node1;
		public BiNode node2;
	}

	public class NodePair {
		BiNode head;
		BiNode tail;

		public NodePair(BiNode head, BiNode tail) {
			this.head = head;
			this.tail = tail;
		}
	}

	public NodePair convert(BiNode root) {
		if (root == null) {
			return null;
		}
		NodePair pair1 = convert(root.node1);
		NodePair pair2 = convert(root.node2);
		if (pair1 != null) {
			concat(pair1.tail, root);
		}
		if (pair2 != null) {
			concat(root, pair2.head);
		}
		return new NodePair(pair1 == null ? root : pair1.head, pair2 == null ? root : pair2.tail);
	}

	public static void concat(BiNode x, BiNode y) {
		x.node2 = y;
		y.node1 = x;
	}

}
