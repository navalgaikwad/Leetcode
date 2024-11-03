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
    int max =0;
    public int longestConsecutive(TreeNode root) {
        helper(root, root.val, 0);
        return max;
    }
    void helper(TreeNode root, int value, int current) {
        if(root == null) {
            return ;
        }
        if(root.val == value) {
            current = current+1;
        }else {
            current = 1;
        }
        max = Math.max(max, current);
        helper(root.left, root.val + 1, current);
        helper(root.right, root.val + 1, current);
    }
}