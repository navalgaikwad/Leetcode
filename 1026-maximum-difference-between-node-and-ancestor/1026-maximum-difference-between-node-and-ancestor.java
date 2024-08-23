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
    
    int ans;
    public int maxAncestorDiff(TreeNode root) {
        ans=maxDiff(root,root.val,root.val);
        return ans;
    }
    public int maxDiff(TreeNode root,int max,int min){
       
        if(root==null){
            return 0;
        }
        max = Math.max(max,root.val);
        min = Math.min(min,root.val);
        
        int leftmax = maxDiff(root.left, max, min);
        int rightmax = maxDiff(root.right, max, min);

        return Math.max(max-min,Math.max(leftmax,rightmax));
    }
}