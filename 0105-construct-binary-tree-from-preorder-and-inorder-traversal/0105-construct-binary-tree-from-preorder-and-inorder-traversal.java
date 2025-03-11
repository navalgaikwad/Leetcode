/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return constructTree(preorder, inorder, 0, inorder.length - 1);
    }

    // preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    public TreeNode constructTree(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }
        int rootValue = preorder[index++];// 3
        int midIndex = map.get(rootValue);// mid = 1
        TreeNode root = new TreeNode(rootValue); // 3
        root.left = constructTree(preorder, inorder, start, midIndex - 1);// 0, 0
        root.right = constructTree(preorder, inorder, midIndex + 1, end);
        return root;
    }
}