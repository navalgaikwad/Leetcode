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
    int k;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        k = inorder.length-1;
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(postorder, 0, inorder.length - 1);
    }
    TreeNode buildTree(int[] postorder, int start, int end) {
        if(start > end || k < 0) {
            return null;
        }
        int value = postorder[k--];
        int mid = map.get(value);
        TreeNode root = new TreeNode(value);
        root.right = buildTree(postorder, mid + 1, end);
        root.left = buildTree(postorder, start, mid - 1);
        
        return root;
    }
}