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
    class Pair{
        TreeNode node;
        int level;
        Pair(TreeNode node, int level){
           this.node = node;
           this.level = level;
        }
    }
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
       Queue<Pair> queue = new LinkedList<>();
       queue.add(new Pair(root, 1));
       while(!queue.isEmpty()){
         Pair current = queue.remove();
        TreeNode curr = current.node;
        int level = current.level;
          if(curr.left == null && curr.right==null){
              return level;
          }
          if(curr.left != null){
             queue.add(new Pair(curr.left, level + 1)); 
          }
           if(curr.right != null){
             queue.add(new Pair(curr.right, level + 1)); 
          }
       }
        return 0;
    }
}