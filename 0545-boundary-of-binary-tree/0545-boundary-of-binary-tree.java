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
     List<Integer> result = new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null) return result;
        result.add(root.val);
        preOrder(root.left, true);
        postOrder(root.right, true);
        return result;
    }
    
    void preOrder(TreeNode root, boolean isLeftMost) {
        if(root == null) return;
        if(isLeftMost || root.left == null && root.right==null) {
            result.add(root.val);
        }
        preOrder(root.left, isLeftMost);
        preOrder(root.right, isLeftMost && root.left == null);
        
    }
    
    void postOrder(TreeNode root, boolean isRightMost) {
        if(root == null) return;
        
        postOrder(root.left, isRightMost&&root.right==null);
        postOrder(root.right, isRightMost);
        if(isRightMost || root.left == null && root.right==null) {
            result.add(root.val);
        }
        
    }
}