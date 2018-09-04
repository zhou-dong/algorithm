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