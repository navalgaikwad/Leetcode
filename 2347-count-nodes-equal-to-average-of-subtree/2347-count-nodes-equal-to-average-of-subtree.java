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
    int result =0;
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
        return result;
    }
    
    Pair dfs(TreeNode root) {
        if(root == null) {
            return new Pair(0, 0);
        }
        Pair left = dfs(root.left);
        Pair right = dfs(root.right);
        
        int values = left.value + right.value + root.val;
        int totalCount = left.count + right.count + 1;
        int average = (values / totalCount);
        if(average == root.val) {
           result++; 
        }
        return new Pair(values, totalCount);
    }
}