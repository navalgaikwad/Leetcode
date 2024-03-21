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
    class Pair {
        TreeNode node;
        int level;
        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return helper(root).node;
        
    }
    
    Pair helper(TreeNode root) {
        if(root == null) {
            return new Pair(null, 0);
        }
        Pair L = helper(root.left);
        Pair R = helper(root.right);
        if(L.level > R.level) {
            return new Pair(L.node, L.level + 1);
        }
        if(L.level < R.level) {
            return new Pair(R.node, R.level + 1);
        }
        return new Pair(root, L.level + 1);
    }
    
}