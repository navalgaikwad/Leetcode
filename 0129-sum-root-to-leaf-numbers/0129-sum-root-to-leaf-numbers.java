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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, new ArrayList<>());
        return sum;
    }
    void helper(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
      
        if(root.left == null && root.right== null){
         String combined = list.stream()
                           .map(String::valueOf)
                           .collect(Collectors.joining("")); 
         sum += Integer.parseInt(combined);
        System.out.print(sum);
        }
        helper(root.left, list);
        helper(root.right, list);
        list.remove(list.size() - 1);
    }
}