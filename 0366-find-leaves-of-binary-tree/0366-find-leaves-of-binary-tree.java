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
    List<Integer> runningList;
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        while(root != null) {
            runningList = new ArrayList<>();
            TreeNode value = dfs(root);
            if(value == null) {
                root = null;
            }
            result.add(new ArrayList<>(runningList));
        }
        
        return result;
    }
    
    public TreeNode dfs(TreeNode root) {
        if(root == null) {
            return null;
        }
        if(root.left == null && root.right == null) {
            runningList.add(root.val);
            return null;
        }
        root.left = dfs(root.left);
        root.right = dfs(root.right);
        
       
        return root;
    }
}