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
    public boolean isEvenOddTree(TreeNode root) {
       Queue<TreeNode> q= new LinkedList<>();
       q.add(root);
       boolean flag=false;
       int prev = Integer.MIN_VALUE;
       while(!q.isEmpty()){
          int size = q.size();
          
          for(int i=0;i<size; i++){
              
              TreeNode current = q.remove();
              int order = current.val;
              if(!flag){
                  if( prev>=order || order%2==0){
                      return false;
                  }
              }else if(flag){
                 if(prev<=order || order%2!=0){
                      return false;
                  } 
              }
              prev = current.val;
              if(current.left != null){
                  q.add(current.left);
              }
              if(current.right!=null){
                  q.add(current.right);
              }
              
           }
           
           if(flag){
            prev=Integer.MIN_VALUE;
        }else{
            prev=Integer.MAX_VALUE;
        }
       
           flag = !flag;
         
       }
     return true;
    }
}