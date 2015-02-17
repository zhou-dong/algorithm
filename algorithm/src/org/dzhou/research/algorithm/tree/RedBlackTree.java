package org.dzhou.research.algorithm.tree;

/**
 * Not finish. JUST A DEMO
 * 
 * constraints:
 * 
 * 1.Every node is either RED or BLACK.
 * 
 * 2.Every nil node is BLACK.
 * 
 * 3.Every RED node has two BLACK child nodes.(Red node can not have red child).
 * 
 * 4.Every path from node x down to the leaf has the same number of BLACK child.
 * 
 * 5.The root node is always BLACK.
 * 
 * Code almost from the URL:
 * 
 * http://alexyyek.github.io/2014/12/23/RBTree/
 * 
 * Thanks: http://alexyyek.github.io/
 * 
 */
public class RedBlackTree<T extends Comparable<T>> {

	private Node<T> root;

	public static enum Color {
		RED, BLACK;
	}

	public static class Node<T extends Comparable<T>> {
		T key;
		Node<T> left;
		Node<T> right;
		Node<T> parent;
		Color color;

		public Node(T key, Node<T> left, Node<T> right, Node<T> parent,
				Color color) {
			this.key = key;
			this.left = left;
			this.right = right;
			this.parent = parent;
			this.color = color;
		}

		public T getKey() {
			return key;
		}

		public String toString() {
			return "" + key + " " + color;
		}
	}

	public RedBlackTree() {
		root = null;
	}

	private Node<T> parentOf(Node<T> node) {
		return (node != null) ? node.parent : null;
	}

	protected Color colorOf(Node<T> node) {
		return (node != null) ? node.color : Color.BLACK;
	}

	private boolean isRed(Node<T> node) {
		return (node != null) && (node.color == Color.RED) ? true : false;
	}

	private boolean isBlack(Node<T> node) {
		return !isRed(node);
	}

	private Node<T> miNode(Node<T> node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

	private void inOrder(Node<T> tree) {
		if (tree != null) {
			inOrder(tree.left);
			System.out.print(tree.key + "\t");
			inOrder(tree.right);
		}
	}

	public void inOrder() {
		inOrder(root);
	}

	private Node<T> maxNode(Node<T> node) {
		while (node.right != null) {
			node = node.right;
		}
		return node;
	}

	private Node<T> succussor(Node<T> node) {
		if (node.right != null) {
			return miNode(node.right);
		}
		Node<T> parent = node.parent;
		while (parent != null && node == parent.right) {
			node = parent;
			parent = parent.parent;
		}
		return parent;
	}

	protected Node<T> preDecessor(Node<T> node) {
		if (node.left != null) {
			return maxNode(node.left);
		}
		Node<T> parent = node.parent;
		while (parent != null && node == parent.left) {
			node = parent;
			parent = parent.parent;
		}
		return parent;
	}

	private void leftRotate(Node<T> x) {
		Node<T> y = x.right;
		x.right = y.left;
		if (y.left != null) {
			y.left.parent = x;
		}
		y.parent = x.parent;
		if (x.parent == null) {
			root = y;
		} else {
			if (x == x.parent.left)
				x.parent.left = y;
			else
				x.parent.right = y;
		}
		y.left = x;
		x.parent = y;
	}

	private void rightRotate(Node<T> x) {
		Node<T> y = x.left;
		x.left = y.right;
		if (y.right != null) {
			y.right.parent = x;
		}

		y.parent = x.parent;
		if (x.parent == null) {
			root = y;
		} else {
			if (x == x.parent.left)
				x.parent.left = y;
			else
				x.parent.right = y;
		}

		y.right = x;
		x.parent = y;
	}

	public Node<T> search(Node<T> tree, T key) {
		if (tree == null || key == tree.key) {
			return tree;
		}

		if (key.compareTo(tree.key) <= 0) {
			return search(tree.left, key);
		} else {
			return search(tree.right, key);
		}
	}

	public Node<T> searchNode(Node<T> tree, T key) {
		while (tree != null && tree.key != key) {
			if (key.compareTo(tree.key) <= 0) {
				tree = tree.left;
			} else {
				tree = tree.right;
			}
		}
		return tree;
	}

	private void insert(Node<T> node) {
		Node<T> y = null;
		Node<T> x = this.root;
		while (x != null) {
			y = x;
			if (node.key.compareTo(x.key) <= 0) {
				x = x.left;
			} else {
				x = x.right;
			}
		}
		node.parent = y;
		if (y == null) {
			root = node;
			node.color = Color.BLACK;
		} else {
			if (node.key.compareTo(y.key) <= 0) {
				y.left = node;
				node.color = Color.RED;
			} else {
				y.right = node;
				node.color = Color.RED;
			}
		}

		insertFixUp(node);
	}

	public void insert(T key) {
		Node<T> node = new Node<T>(key, null, null, null, Color.BLACK);
		if (node != null) {
			insert(node);
		}
	}

	private void insertFixUp(Node<T> node) {
		while (node.parent != null && isRed(node.parent)) {
			if (parentOf(node) == parentOf(parentOf(node)).left) {
				Node<T> uncle = parentOf(parentOf(node)).right;
				if (isRed(uncle)) {
					parentOf(node).color = Color.BLACK;
					uncle.color = Color.BLACK;
					parentOf(parentOf(node)).color = Color.RED;
					node = parentOf(parentOf(node));
				} else {
					if (parentOf(node).right == node) {
						node = parentOf(node);
						leftRotate(node);
					}

					parentOf(node).color = Color.BLACK;
					parentOf(parentOf(node)).color = Color.RED;
					rightRotate(parentOf(parentOf(node)));
				}
			} else {
				Node<T> uncle = parentOf(parentOf(node)).left;
				if (isRed(uncle)) {
					parentOf(node).color = Color.BLACK;
					uncle.color = Color.BLACK;
					parentOf(parentOf(node)).color = Color.RED;
					node = parentOf(parentOf(node));
				} else {
					if (parentOf(node).left == node) {
						node = parentOf(node);
						rightRotate(node);
					}
					parentOf(node).color = Color.BLACK;
					parentOf(parentOf(node)).color = Color.RED;
					leftRotate(parentOf(parentOf(node)));
				}
			}
		}
		if (node == root) {
			node.color = Color.BLACK;
		}
	}

	private Node<T> remove(Node<T> node) {
		Node<T> replace = null;
		if (node.left == null || node.right == null) {
			replace = node;
		} else {
			replace = succussor(node);
		}
		Node<T> child = replace.left != null ? replace.left : replace.right;

		if (child == null) {
			child = new Node<T>(null, null, null, replace.parent, Color.BLACK);
		}
		child.parent = replace.parent;

		if (replace.parent == null) {
			root = child;
		} else {
			if (replace == replace.parent.left)
				replace.parent.left = child;
			else
				replace.parent.right = child;
		}

		if (replace != node) {
			node.key = replace.key;
		}
		if (isBlack(replace)) {
			removeFixUp(child);
		}
		return replace;
	}

	public void remove(T key) {
		Node<T> node = null;
		if ((node = searchNode(root, key)) != null) {
			remove(node);
		}
	}

	private void removeFixUp(Node<T> node) {

		while (node != this.root && node.color == Color.BLACK) {
			if (node == parentOf(node).left) {
				Node<T> uncle = parentOf(node).right;
				if (isRed(uncle)) {
					parentOf(node).color = Color.RED;
					uncle.color = Color.BLACK;
					leftRotate(parentOf(node));
					uncle = parentOf(node).right;
				}
				if (isBlack(uncle.left) && isBlack(uncle.right)) {
					uncle.color = Color.RED;
					node = parentOf(node);
				} else {
					if (isBlack(uncle.right)) {
						uncle.left.color = Color.BLACK;
						uncle.color = Color.RED;
						rightRotate(uncle);
						uncle = parentOf(node).right;
					}
					uncle.color = parentOf(node).color;
					parentOf(node).color = Color.BLACK;
					uncle.right.color = Color.BLACK;
					leftRotate(parentOf(node));
					node = root;
				}
			} else {
				Node<T> uncle = parentOf(node).left;
				if (isRed(uncle)) {
					parentOf(node).color = Color.RED;
					uncle.color = Color.BLACK;
					rightRotate(parentOf(node));
					uncle = parentOf(node).left;
				}
				if (isBlack(uncle.left) && isBlack(uncle.right)) {
					uncle.color = Color.RED;
					node = parentOf(node);
				} else {
					if (isBlack(uncle.left)) {
						uncle.right.color = Color.BLACK;
						uncle.color = Color.RED;
						leftRotate(uncle);
						uncle = parentOf(node).left;
					}
					uncle.color = parentOf(node).color;
					parentOf(node).color = Color.BLACK;
					uncle.left.color = Color.BLACK;
					rightRotate(parentOf(node));
					node = root;
				}
			}
		}
		node.color = Color.BLACK;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 40, 30, 60, 90, 70, 20, 50, 80 };
		RedBlackTree<Integer> tree = new RedBlackTree<Integer>();
		for (int i : arr) {
			tree.insert(i);
		}
		tree.inOrder();
		tree.remove(20);
		System.out.println();
		tree.inOrder();
	}
}