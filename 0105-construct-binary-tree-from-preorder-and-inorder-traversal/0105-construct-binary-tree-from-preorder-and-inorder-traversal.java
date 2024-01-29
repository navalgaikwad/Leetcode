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
    Map<Integer, Integer> map = new HashMap<>();
    int i=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(0, inorder.length - 1, preorder);
    }
    
    TreeNode buildTree(int start, int end, int[] preorder) {
        if(start > end) {
            return null;
        }
        int value = preorder[i++];
        int mid = map.get(value);
        TreeNode root = new TreeNode(value);
        root.left = buildTree(start, mid - 1, preorder);
        root.right = buildTree(mid+1, end, preorder);
        return root;
    }
}