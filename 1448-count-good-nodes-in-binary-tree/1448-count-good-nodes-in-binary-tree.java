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
    //int min = Integer.MIN_VALUE;
    int count =0;
    public int goodNodes(TreeNode root) {
        helper(root, Integer.MIN_VALUE);
        return count;
    }
     void helper(TreeNode root, int prev) {
         if(root == null) {
             return;
         }
         if(root.val >= prev) {
             count++;
             prev = root.val;
         }
         helper(root.left, prev);
         helper(root.right, prev);
     }
}