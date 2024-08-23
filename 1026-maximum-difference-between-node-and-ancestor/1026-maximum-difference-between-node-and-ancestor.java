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
    int ans =0;
    public int maxAncestorDiff(TreeNode root) {
        helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
        return ans;
    }
    
    int helper(TreeNode root, int min, int max) {
        if(root == null) {
            return 0;
        }
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        
        int left = helper(root.left, min, max);
        int right = helper(root.right, min, max);
        
        ans = Math.max(ans, max - min);
        
        return Math.max(max - min, Math.max(left, right));
    }
}