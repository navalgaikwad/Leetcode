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
    TreeNode findRoot(TreeNode root, int startValue, int destValue) {
        if(root == null || root.val == startValue || root.val == destValue) {
            return root;
        }
        TreeNode left = findRoot(root.left, startValue, destValue);
        TreeNode right = findRoot(root.right, startValue, destValue);
        if(left == null) {
            return right;
        }
        if(right == null) {
            return left;
        }
        return root;
    }
    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();
    boolean findStartPath(TreeNode root, int startValue) {
        if(root == null) {
            return false;
        }
        if(root.val == startValue) {
            return true;
        }
        boolean left = findStartPath(root.left, startValue);
        boolean right = findStartPath(root.right, startValue);
        if(left || right) {
            sb1.append("U");
        }
        return left || right;
    }
     boolean findDestinationPath(TreeNode root, int destValue) {
        if(root == null) {
            return false;
        }
        if(root.val == destValue) {
            return true;
        }
        boolean left = findDestinationPath(root.left, destValue);
        boolean right = findDestinationPath(root.right, destValue);
        if(left) {
            sb2.append("L");
        }
         if(right) {
            sb2.append("R");
        }
        return left || right;
    }
    
    public String getDirections(TreeNode root, int startValue, int destValue) {
        root = findRoot(root, startValue, destValue);
        findStartPath(root, startValue);
        findDestinationPath(root, destValue);
        sb1.append(sb2.reverse());
        return sb1.toString();
    }
}