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
    public int rob(TreeNode root) {
        int[] value = helper(root);
        return Math.max(value[0], value[1]);
    }
    
    int[] helper(TreeNode root) {
        if(root == null) return new int[2];
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int[] result = new int[2];
        result[0] =Math.max(left[0], left[1])+ Math.max(right[0], right[1]);
        result[1] = root.val + left[0] +  right[0];
        return result;
    }
}