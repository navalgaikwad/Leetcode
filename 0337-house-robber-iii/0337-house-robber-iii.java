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
    class Node{
        int include;
        int exclude;
        Node(int include, int exclude){
            this.include=include;
            this.exclude=exclude;
        }
    }
    public int rob(TreeNode root) {
        Node node = dfs(root);
        return Math.max(node.include, node.exclude);
    }
    
    Node dfs(TreeNode root) {
        if(root == null) {
            return new Node(0, 0);
        }
        Node left = dfs(root.left);
        Node right = dfs(root.right);
        
        int leftSide = root.val + left.exclude + right.exclude;
        int rightSide =  Math.max(left.include, left.exclude) + Math.max(right.include, right.exclude);
        return new Node(leftSide, rightSide);
    }
}