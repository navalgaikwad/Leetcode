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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        i =  postorder.length - 1; //for post start from end
        for(int i =0 ;i<inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(postorder, 0, postorder.length-1);
    }
    TreeNode buildTree(int[] postorder, int low, int high) {
        if(low > high || i < 0) {
            return null;
        }
        int rootValue =postorder[i--];//satrt from end
        TreeNode root = new TreeNode(rootValue);
        root.right = buildTree(postorder, inorderMap.get(rootValue) + 1, high);
        root.left = buildTree(postorder, low, inorderMap.get(rootValue) - 1);
        
        return root;
    }
}