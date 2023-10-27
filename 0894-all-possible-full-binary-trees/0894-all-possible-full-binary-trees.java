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
    public List<TreeNode> allPossibleFBT(int n) {
     
        HashMap<Integer, List<TreeNode>> memo = new HashMap<>();
        
        
       System.out.print(memo);
        return helper(n , memo);
        
    }
    List<TreeNode> helper(int n,  HashMap<Integer, List<TreeNode>> memo){
       if(memo.containsKey(n)){
           return memo.get(n);
       }
         if(n %2 == 0){
            return new ArrayList<TreeNode>();
        }
        if(n == 1){
            return Arrays.asList(new TreeNode());
        }
         List<TreeNode> res = new ArrayList<TreeNode>();
        for(int i = 1; i < n; i+=2){
          List<TreeNode> left =  helper(i, memo); //left
          List<TreeNode> right =  helper(n - i -1, memo); //right
          for(TreeNode l: left){
              for(TreeNode r: right){
               TreeNode root = new TreeNode(0, l, r);   
               res.add(root);
            }
          }
        }
        memo.put(n, res);
        return res;
    } 
}