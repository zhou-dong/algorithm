# Trees and Graphs

## Tree

### Binary Tree Traversal

#### In-order Traversal

如果是遍历binary search tree的话，会按照升序访问整个tree。

```java
void inOrderTraversal(TreeNode node) {
	if (node != null) {
		inOrderTraversal(node.left);
		visit(node);
		inOrderTraversal(node.right);
	}
}
```

#### Pre-order Traversal

首先访问root node。

```java
void preOrderTraversal(TreeNode node) {
	if (node != null) {
		visit(node);
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}
}
```

#### Post-order Traversal

最后访问root node。

```java
void postOrderTraversal(TreeNode node) {
	if (node != null) {
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		visit(node);
	}
}
```

### Heaps

#### insert

1. 把新的node，insert到树的最后一个node的后面
2. swap the new node to appropriate position

#### remove

1. remove the node from root
2. swap the last node to root
3. bubble down and swap the new node

插入和删除这样的操作，都是为了让整个tree始终保持balance。

## Graph

如果要在tree中搜索结点S到T的路径，使用bidirectional search要比breadth-first search效率高。

bidirectional search: two searches (one from s and one from t).
