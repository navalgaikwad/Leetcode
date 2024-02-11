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
    public int rob(TreeNode root) {
        return Math.max(robHouses(root), root.val);
    }

    // return non adjacent values
    // update each root with values that represents the max value till that root possible if the root house is also robbed
    private int robHouses(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = robHouses(root.left);
        int right = robHouses(root.right);

        int nonAdjacentValues = (root.left != null) ? root.left.val : 0;
        nonAdjacentValues += (root.right != null) ? root.right.val : 0;

        root.val = Math.max(root.val + left + right, nonAdjacentValues);

        return nonAdjacentValues;
    }
}