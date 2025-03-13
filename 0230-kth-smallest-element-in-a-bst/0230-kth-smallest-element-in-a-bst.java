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
    Integer ans = 0;
    int level = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }

    void dfs(TreeNode root, int k) {
        if(root == null) return;
        dfs(root.left,k);
        level= level+1;
        if(level == k && ans==0) {
            ans = root.val;
            return;
        }
        dfs(root.right,k);
    }
}