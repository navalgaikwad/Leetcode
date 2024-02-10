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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return helper(root, low, high);
    }
    
    TreeNode helper(TreeNode root, int low, int high) {
        if(root == null) {
            return null;
        }
        root.left = helper(root.left, low, high);
        root.right = helper(root.right, low, high);
        
        if(root.left == null && root.right!=null && (root.val < low || root.val > high)) {
            return root.right;
        }
        if(root.right == null && root.left!=null && (root.val < low || root.val > high)) {
            return root.left;
        } 
        if(root.left == null && root.right == null && (root.val < low || root.val > high)) {
            return null;
        }
        return root;
    }
}