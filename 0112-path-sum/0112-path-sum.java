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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helepr(root, targetSum, 0);
    }
    
    boolean helepr(TreeNode root, int targetSum, int sum) {
        if(root == null) {
            return false;
        }
        sum = sum + root.val;
        if(root.left == null && root.right == null && sum == targetSum) {
           return true; 
        }
        boolean left = helepr(root.left, targetSum, sum);
        boolean right = helepr(root.right, targetSum, sum);
        
        return left || right;
    }   
}