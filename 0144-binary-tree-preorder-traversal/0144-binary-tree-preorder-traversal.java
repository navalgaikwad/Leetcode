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
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            List<Integer> baseList = new ArrayList<>();
            return baseList;
        }
       List<Integer> left =  preorderTraversal(root.left);
       List<Integer> right =  preorderTraversal(root.right);
       
        ArrayList<Integer> result = new ArrayList<>();
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        return result;
    }
}