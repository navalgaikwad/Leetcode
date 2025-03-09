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
    TreeNode lca = null;
    int maxDept = 0;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        return lca;
    }

    int dfs(TreeNode root, int dept) {
        if(root == null) return dept;
        int left = dfs(root.left, dept + 1);
        int right = dfs(root.right, dept + 1);
        maxDept = Math.max(maxDept, Math.max(left, right));
        if(left == maxDept && maxDept == right) {
            lca = root;
        }
        return Math.max(left, right);
    }
}