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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        PriorityQueue<Long>pq=new PriorityQueue<>();
       // k=k-1;
        while(!queue.isEmpty()){
            int size = queue.size();
            long sum=0;
            for(int i=0; i<size; i++){
                 TreeNode current =queue.remove();
                 sum=sum + current.val;
                if(current.left!=null){
                    queue.add(current.left);
                }
                if(current.right!=null){
                    queue.add(current.right);
                }
            }
            pq.add(sum);
            while(pq.size()>k){
            pq.remove();
        }
        }
        if(k>pq.size()) return -1;
       // System.out.print(pq);
       
        return pq.peek();
    }
}