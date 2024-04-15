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
    int count = 0;
    
    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return count;
    }
    
    int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int left = helper(root.left);
        int right = helper(root.right);
        int leftSide =0; int rightSide =0;
        if(root.left!=null  && root.left.val == root.val) {
            leftSide +=left + 1;
        }
        if(root.right!=null  && root.right.val == root.val) {
            rightSide +=right + 1;
        }
        count = Math.max(count, leftSide + rightSide);
        return Math.max(leftSide, rightSide);
    }
}