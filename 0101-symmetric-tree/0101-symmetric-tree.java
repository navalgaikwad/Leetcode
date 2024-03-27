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
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }
    
    boolean helper(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if((left == null && right!=null) || (right == null && left!=null)) {
            return false;
        }
        return left.val == right.val && helper(left.right, right.left) &&
           helper(left.left, right.right);
    }
}

/*
negaytive
root can be an
left side
right side
root.left 
root.right

//condition
left
right
left.val!=right.val
retrun false;

left == null && righht == null
return true

left == null && right!=null || right==null && left!=null return false

*/