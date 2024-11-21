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
    public TreeNode deleteNode(TreeNode root, int key) {
        return dfs(root, key);
    }
    
    
    TreeNode dfs(TreeNode root, int key) {
        if(root == null) return null;
        if(key < root.val) {
            root.left =  dfs(root.left, key);
        }else if(key > root.val) {
            root.right= dfs(root.right, key);
        }else {
            if(root.left == null && root.right!=null && root.val == key) {
                return root.right;
            }else  if(root.left != null && root.right ==null && root.val == key) {
                return root.left;
            }else  if(root.left == null && root.right==null && root.val == key) {
                return null;
            }else if(root.left!=null && root.right!=null && root.val == key){
                TreeNode temp = helper(root.right);
                root.val = temp.val;
                root.right = dfs(root.right, temp.val);
            }
        }
        return root;
    }
    
    TreeNode helper(TreeNode root) {
       
        while(root.left!=null) {
            root = root.left;
        }
        return root;
    }
}