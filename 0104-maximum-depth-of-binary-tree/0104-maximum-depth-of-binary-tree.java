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
    public int maxDepth(TreeNode root) {
        int value = dfs(root);
        return value==Integer.MIN_VALUE?0:value;
    }
    
    int dfs(TreeNode root) {
        if(root == null) return Integer.MIN_VALUE;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(root.left==null && root.right==null) return 1;
        
        return 1+ Math.max(left, right);
    }
}