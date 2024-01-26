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
    List<Integer> list = new ArrayList<>();
    int count;
    public BSTIterator(TreeNode root) {
        helper(root);
        count =0;
        
    }
    
    public int next() {
        
        int val = list.get(count);
        count++;
        return val;
    }
    
    public boolean hasNext() {
        return count != list.size();
    }
   void helper(TreeNode root) {
        if(root == null) {
            return;
        }
        helper(root.left);
        list.add(root.val);
        helper(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */