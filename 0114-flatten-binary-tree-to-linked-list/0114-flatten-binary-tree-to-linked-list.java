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
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        dfs(root);
        //return prev;
    }
    void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        dfs(root.right);
        dfs(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}