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
    TreeNode findAncestor(TreeNode root, int startValue, int destValue) {
        if(root == null || root.val == startValue || root.val == destValue) {
            return root;
        }
        TreeNode left = findAncestor(root.left, startValue, destValue);
        TreeNode right = findAncestor(root.right, startValue, destValue);
        
        if(left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
    StringBuilder leftSide = new StringBuilder();
    StringBuilder rightSide = new StringBuilder();
    
    boolean helperParent(TreeNode root, int startValue) {
        if(root == null) {
            return false;
        }
        if(root.val == startValue) {
            return true;
        }
        boolean left = helperParent(root.left, startValue);
        boolean right = helperParent(root.right, startValue);
        if(left || right) {
            leftSide.append("U");
        }
        return left || right;
        
    }
    boolean helperDestValue(TreeNode root, int destValue) {
        if(root == null) {
            return false;
        }
        if(root.val == destValue) {
            return true;
        }
        boolean left = helperDestValue(root.left, destValue);
        boolean right = helperDestValue(root.right, destValue);
        if(left) {
            rightSide.append("L");
        }
        if(right) {
            rightSide.append("R");
        }
        return left || right;
        
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        root = findAncestor(root, startValue, destValue);
        helperParent(root, startValue);
        helperDestValue(root, destValue);
        leftSide.append(rightSide.reverse());
        return leftSide.toString();
    }
}