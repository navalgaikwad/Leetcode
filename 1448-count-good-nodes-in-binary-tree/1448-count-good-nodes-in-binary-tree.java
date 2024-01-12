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
    int counter = 0;

    public int goodNodes(TreeNode root) {
        helper(root, Integer.MIN_VALUE);
        return counter;
    }

    void helper(TreeNode root, int maxValue) {
        if (root == null) {
            return;
        }

        if (root.val >= maxValue) {
            counter++;
            maxValue = root.val;
        }

        helper(root.left, maxValue);
        helper(root.right, maxValue);
    }
}
