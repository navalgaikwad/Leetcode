/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
List<Integer> nodeList = new ArrayList<>();
    int index =0;
    public BSTIterator(TreeNode root) {
        helper(root);
    }
    
    public int next() {
        return nodeList.get(index++);
    }
    
    public boolean hasNext() {
        return index < nodeList.size();
    }
    void helper(TreeNode root) {
        if(root == null) return;
        helper(root.left);
        nodeList.add(root.val);
        helper(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */