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
     class Pair{
        int diameter;
        int dept;
        Pair(int diameter, int dept){
            this.diameter = diameter;
            this.dept = dept;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        Pair pair = helper(root);
        return pair.diameter;
    }
    
    Pair helper(TreeNode root){
        if(root == null){
            return new Pair(0, 0);
        }
        Pair left  = helper(root.left);
        Pair right =  helper(root.right);
        
        int daimeter = Math.max(Math.max(left.diameter, right.diameter), left.dept + right.dept);
        
        int dept = Math.max(left.dept, right.dept) + 1;
        return new Pair(daimeter, dept);
        
    }
}