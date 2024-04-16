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
    int j=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i =0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, inorder.length - 1);
    }
    
    TreeNode buildTree(int[] preorder, int s, int e) {
        if(s > e) {
            return null;
        }
        int value = preorder[j++];
        int mid = map.get(value);
        TreeNode root = new TreeNode(value);
        root.left = buildTree(preorder, s, mid - 1 );
        root.right = buildTree(preorder, mid+1, e);
        return root;
    }
}