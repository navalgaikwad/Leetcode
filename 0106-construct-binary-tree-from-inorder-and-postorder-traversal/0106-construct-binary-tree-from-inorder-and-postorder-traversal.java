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
    //Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
    int postIndex = 0;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
       postIndex =  postorder.length - 1;
       for(int i=0;i<inorder.length; i++){
           map.put(inorder[i], i);
       }
       return helper(postorder, 0, postorder.length - 1); 
    }
    TreeNode helper(int[] postorder, int start, int end) {
        if (start > end || postIndex < 0) {  
            return null;
        }
        int post = postorder[postIndex--];

        TreeNode root = new TreeNode(post);
        root.right = helper(postorder, map.get(post) + 1, end);  
        root.left = helper(postorder, start, map.get(post) - 1);
       
        return root;
    }
}