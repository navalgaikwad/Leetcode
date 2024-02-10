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
    int count =0;
    public int longestUnivaluePath(TreeNode root) {
         dfs(root);
        return count;
    }
    
    int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftSide = 0; int rightSide = 0;
        
        int left = dfs(root.left);
        int right = dfs(root.right);
        
        if (root.left!=null && root.val == root.left.val) {
            leftSide += left + 1;
        }
         if (root.right!=null && root.val == root.right.val) {
            rightSide += right + 1;
        }
        count = Math.max(count, leftSide + rightSide);
        return Math.max(leftSide, rightSide);
    }
}