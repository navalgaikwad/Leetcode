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
    int val=Integer.MAX_VALUE;
    TreeNode prev=null;
    public void tree(TreeNode root )
    {
        if(root==null)
            return ;
            tree(root.left);
            if(prev!=null)
                val=Math.min(val,root.val-prev.val);
            prev=root;
            tree(root.right);  
    }
    public int minDiffInBST(TreeNode root) {
        tree(root);
        return val;
    }
}
