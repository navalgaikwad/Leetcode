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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<List<Integer>>result=new ArrayList<>();;
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer>subList=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode current=queue.remove();
                subList.add(current.val);
                if(current.left!=null){
                    queue.add(current.left);
                }
                 if(current.right!=null){
                    queue.add(current.right);
                }
                
            }
            result.add(subList);
        }
        Collections.reverse(result);
     return result;
    }
}