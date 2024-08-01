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
    int count =0;
    class Pair {
        int value;
        int count;
        Pair(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return count;
    }
    
    Pair dfs(TreeNode root) {
        if(root == null) {
            return new Pair(0, 0);
        }
        Pair left = dfs(root.left);
        Pair right = dfs(root.right);
        
        int value = left.value + right.value + root.val;
        int totalCount = left.count + right.count + 1;
        int average = (value / totalCount);
        if(average == root.val) {
           count++; 
        }
        return new Pair(value, totalCount);
    }
}