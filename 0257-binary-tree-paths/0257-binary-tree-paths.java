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
    List<String> result = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        helper(root, "");
        return result;
    }
    
     public void helper(TreeNode root, String running) {
        if(root == null) {
            return;    
        }
         running = running+""+root.val+"->";
         if(root.left == null && root.right == null) {
             result.add(new String(running.substring(0, running.length()-2)));
         }
         helper(root.left, running);
         helper(root.right,  running);
         
    }
    
}