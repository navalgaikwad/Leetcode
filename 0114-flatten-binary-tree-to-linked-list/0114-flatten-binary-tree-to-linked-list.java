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
    TreeNode prev =null;
    public void flatten(TreeNode root) {
        helper(root);
    }
    void helper(TreeNode root) {
        if(root == null) {
            return;
        }
        helper(root.right);
        helper(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}