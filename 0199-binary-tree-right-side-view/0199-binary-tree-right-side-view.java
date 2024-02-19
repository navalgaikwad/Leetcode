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
    List<Integer> ans = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        helper(root, 0);
	    return ans;
    }
     void helper(TreeNode root, int level) {
        if(root == null) {
            return;
        }

        if(level == ans.size()) {
            ans.add(root.val);//1, 3
        }
        helper(root.right, level + 1);//2
        helper(root.left, level + 1);
    }
}

   