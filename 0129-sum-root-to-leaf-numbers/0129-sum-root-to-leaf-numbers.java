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
    public int sumNumbers(TreeNode root) {
        int totalUptillNow = 0;
        int sum = helper(root, totalUptillNow);
        return sum;
    }
    
    int helper(TreeNode root, int sum) {
        if(root == null) return 0;
        
        sum = sum *10+root.val;
        if(root.left == null && root.right==null) return sum;//leaf path vvimp
        
        int left = helper(root.left, sum);
        int right = helper(root.right, sum);
        
        return left + right;
    }
}


