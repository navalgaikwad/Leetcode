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
    public TreeNode invertTree(TreeNode root) {
        return helper(root);
    }
    TreeNode helper(TreeNode root) {
        if(root == null ) {
            return null;
        }
        TreeNode node = new TreeNode(root.val);
        node.left = helper(root.right);
        node.right =helper(root.left);
        return node;
    }
}