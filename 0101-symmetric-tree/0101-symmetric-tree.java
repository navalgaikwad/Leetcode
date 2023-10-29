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
    //root is null return true;
    //root left & root right 
    public boolean isSymmetric(TreeNode root) {
        
        return helper(root.left, root.right);
    }
    
    boolean helper(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
    
        if((left == null && right!=null) || (left!=null && right==null)){
            return false;
        }
        
        if(left.val != right.val || right.val != left.val){
            return false;
        }
     
     boolean leftSide =  helper(left.left, right.right);  
     boolean rightSide = helper(left.right, right.left);  
     return leftSide && rightSide;
    }
}