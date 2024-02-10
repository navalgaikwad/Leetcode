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
    int prev =0;
    public TreeNode convertBST(TreeNode root) {
        return dfs(root);
    }
    
    TreeNode dfs(TreeNode root) {
        if(root == null) {
            return null;
        }
        root.right =dfs(root.right);
        root.val = root.val + prev;
        prev = root.val;
        root.left = dfs(root.left);
        return root;
    }
}