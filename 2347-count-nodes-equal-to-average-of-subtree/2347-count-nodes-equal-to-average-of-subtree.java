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
    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return result;
        
    }
    int[] helper(TreeNode root) {
        if(root == null) return new int[]{0, 0};
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int count = left[0] + right[0] + 1;
        int number = right[1] + left[1] + root.val;
        int average = number / count;
        if(average == root.val) {
            result++;
        }
        return new int[]{count, number};

    }
}