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
    int maxlevel=0;
    int last=0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return last;
    }
    void dfs(TreeNode root, int level){
        if(root ==null){
            return;
        }
        if(level==maxlevel){
            maxlevel++;
            last=root.val;
        }
        dfs(root.left, level+1);
        dfs(root.right, level+1);
        
    }
}