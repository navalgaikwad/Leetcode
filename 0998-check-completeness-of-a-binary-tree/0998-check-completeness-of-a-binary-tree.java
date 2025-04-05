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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (q.peek() != null) {//check peek is not null
            TreeNode node = q.remove();
            q.add(node.left);
            q.add(node.right);
        }
        while (!q.isEmpty() && q.peek() == null) {//peek is null
            q.remove();
        }
        return q.isEmpty();

    }
}