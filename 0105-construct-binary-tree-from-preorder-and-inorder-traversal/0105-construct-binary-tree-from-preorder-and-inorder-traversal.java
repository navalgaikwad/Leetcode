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
    Map<Integer, Integer> inorderMap = new HashMap<>();
    int i = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i =0 ;i<inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length-1);
    }
    TreeNode helper(int[] preorder, int low, int high) {
        if(low > high) {
            return null;
        }
        int rootValue = preorder[i++];
        TreeNode root = new TreeNode(rootValue);
        root.left = helper(preorder, low, inorderMap.get(rootValue) - 1);
        root.right = helper(preorder, inorderMap.get(rootValue) + 1, high);
        return root;
    }
}