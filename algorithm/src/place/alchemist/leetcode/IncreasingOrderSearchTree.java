// 897. Increasing Order Search Tree
class QueueSolution {

    public TreeNode increasingBST(TreeNode root) {
     
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        inorder(root, queue);
        if(queue.size() == 0){
            return null;
        }
        
        TreeNode result = queue.remove();
        cleanChildren(result);
        TreeNode previous = result;

        while(queue.size() > 0) {
            TreeNode current = queue.remove();
            cleanChildren(current);
            previous.right = current;
            previous = current;
        }
        
        return result;
    }
    
    private void cleanChildren(TreeNode node){
        node.left = null;
        node.right = null;
    }
    
    private void inorder(TreeNode node, Queue<TreeNode> queue) {
        if (node != null) {
            inorder(node.left, queue);
            queue.add(node);
            inorder(node.right, queue);
        }
    }

}

class StackSolution {

    public TreeNode increasingBST(TreeNode root) {
     
        Stack<TreeNode> stack = new Stack<TreeNode>();
        inorder(root, stack);
        if(stack.size() == 0){
            return null;
        }
        
        TreeNode previous = stack.pop();
        cleanChildren(previous);
        
        while(stack.size() > 0) {
            TreeNode current = stack.pop();
            cleanChildren(current);
            current.right = previous;
            previous = current;
        }
        
        return previous;
    }
    
    private void cleanChildren(TreeNode node){
        node.left = null;
        node.right = null;
    }
    
    private void inorder(TreeNode node, Stack<TreeNode> stack) {
        if (node != null) {
            inorder(node.left, stack);
            stack.push(node);
            inorder(node.right, stack);
        }
    }

}

class RecursiveSolution {
    
    private TreeNode current = null;
    
    public TreeNode increasingBST(TreeNode root) {
        TreeNode result = new TreeNode(-1);
        current = result;
        inorder(root);
        return result.right;
    }
    
    private void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            node.left = null;
            current.right = node;
            current = node;
            inorder(node.right);
        }
    }

}
