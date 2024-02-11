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
class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    boolean dfs(TreeNode root, long min, long max) {
        if(root == null) {
            return true;
        }
        if(min >=root.val   || max<=root.val) {
            return false;
        }
        boolean left = dfs(root.left, min , root.val);
        boolean right = dfs(root.right, root.val, max);
        return left && right;
    }
}