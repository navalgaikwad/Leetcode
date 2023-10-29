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
    int result = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, "");
        return result;
    }
    
    void helper(TreeNode root, String sum){
        if(root == null){
            return;
        }
        sum = sum + root.val;
        if(root.left == null && root.right == null){
            result += Integer.parseInt(sum);
            return;
        }
        helper(root.left, sum);
        helper(root.right, sum);
        
    }
}