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
    int maxDepth = 0;
    TreeNode lca = null;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        findDepth(root, 0);
        return lca;
    }

    private int findDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }

        int leftDepth = findDepth(root.left, depth + 1);
        int rightDepth = findDepth(root.right, depth + 1);

        maxDepth = Math.max(maxDepth, Math.max(leftDepth, rightDepth));

        if (leftDepth == maxDepth && rightDepth == maxDepth) {
            lca = root;
        }

        return Math.max(leftDepth, rightDepth);
    }
}
