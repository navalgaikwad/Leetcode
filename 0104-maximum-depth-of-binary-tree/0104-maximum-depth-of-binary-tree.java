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
    int max = Integer.MIN_VALUE;
    public int maxDepth(TreeNode root) {
//         if(root == null){
//             return 0;
//         }
        
//        int left = maxDepth(root.left);
//        int right = maxDepth(root.right);
//        int dept = 1 + Math.max(left, right);
//         return dept;
        helper(root, 0);
        return max;
            
    }
    
    void helper( TreeNode root, int sum){
        if(root == null ){
            max = Math.max(max, sum);
            return;
        }
        //sum = sum + 1;
        helper(root.left, sum + 1 );
        helper(root.right, sum + 1);
    }
}