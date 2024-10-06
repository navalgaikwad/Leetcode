/**
* Definition for a binary tree node.
* public class TreeNode {
*     int val;
*     TreeNode left;
*     TreeNode right;
*     TreeNode() {}
*     TreeNode(int val) { this.val = val; }
*     TreeNode(int val, TreeNode left, TreeNode right) {
*         this.val = val;
*         this.left = left;
*         this.right = right;
*     }
* }
*/
class Solution {
public boolean isValidBST(TreeNode root) {
if(root == null) {
return true;
}
return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
}
boolean helper(TreeNode root, int min, int max) {
if(root == null) {
return true;