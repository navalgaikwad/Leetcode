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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         i =  postorder.length - 1; //for post start from end
       for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(0, inorder.length - 1, postorder);
    }
    
    TreeNode buildTree(int start, int end, int[] postorder) {
        if(start > end || i < 0) {
            return null;
        }
        int value = postorder[i--];
        int mid = map.get(value);
        TreeNode root = new TreeNode(value);
        root.right = buildTree(mid+1, end, postorder);
        root.left = buildTree(start, mid - 1, postorder);
        
        return root;
    }
}