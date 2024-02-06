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
    
    TreeNode findANCES(TreeNode root, int startValue, int destValue) {
        if(root == null) {
            return null;
        }
        if(root.val == startValue || root.val == destValue) {
            return root;
        }
        TreeNode left = findANCES(root.left, startValue, destValue);
        TreeNode right = findANCES(root.right, startValue, destValue);
        if(left==null) {
            return right;
        }
        if(right == null) {
            return left;
        }
        return root;
    }
    StringBuilder sbleft = new StringBuilder();
    StringBuilder sbright = new StringBuilder();
    
    boolean helper1(TreeNode root, int s) {
        if(root == null) {
            return false;
        }
        if(root.val == s) {
            return true;
        }
        boolean left = helper1(root.left, s);
        boolean right = helper1(root.right, s);
        
        if(left || right) {
            sbleft.append("U");
        }
        return left || right;
        
    }
    
    boolean helper2(TreeNode root, int s) {
        if(root == null) {
            return false;
        }
        if(root.val == s) {
            return true;
        }
        boolean left = helper2(root.left, s);
        boolean right = helper2(root.right, s);
        
        if(left) {
            sbright.append("L");
        }
        if(right) {
           sbright.append("R"); 
        }
        return left || right;
        
    }
    
    public String getDirections(TreeNode root, int s, int d) {
        root =  findANCES(root, s, d);
        helper1(root, s);
        helper2(root, d);
        sbleft.append(sbright.reverse());
        return sbleft.toString();
    }
    
    
}