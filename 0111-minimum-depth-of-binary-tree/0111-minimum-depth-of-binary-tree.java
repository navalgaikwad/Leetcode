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
    public int minDepth(TreeNode root) {
        int vlaue = helper(root);
        return  vlaue == Integer.MAX_VALUE ? 0 :vlaue;
    }
    int helper(TreeNode root) {
         if(root == null){
            return Integer.MAX_VALUE;
        }
        int left  = helper(root.left);
        int right = helper(root.right);
         if(root.left == null && root.right == null) {
            return 1;
        }
        int min = 1+ Math.min(left, right);
        return min;
    }
}