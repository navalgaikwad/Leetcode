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
    int global = 0;
    public int findTilt(TreeNode root) {
        helper(root);
        return global;
    }
    
    int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        //TreeNode newRoot = new TreeNode();
        int gl =0;
        int left = helper(root.left);
        int right = helper(root.right);
       
        global += Math.abs(left - right);
        gl +=Math.abs(left - right);
        int result = root.val + left + right;
        root.val = gl;
        return result;
    }
}