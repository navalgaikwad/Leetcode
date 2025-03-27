/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int result = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        helper(root, low, high);
        return result;
    }

    void helper(TreeNode root, int low, int high) {
        if (root == null)
            return;
        if (root.val >= low && root.val <= high) {
            result += root.val;
        }
        helper(root.left, low, high);
        helper(root.right, low, high);
    }
}