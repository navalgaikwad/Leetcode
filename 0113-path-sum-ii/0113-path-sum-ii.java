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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        //List<Integer>runningList = new ArrayList<>();
        dfs(result,  new ArrayList<>(), root, targetSum, 0);
        return result;
    }
    
    void dfs(List<List<Integer>> result, List<Integer>runningList, TreeNode root, int targetSum, int sum){
        if(root==null ){
            return;
        }
        sum =sum+root.val;
        runningList.add(root.val);
        if(targetSum==sum && root.left==null && root.right==null){
           result.add(new ArrayList<>(runningList)); 
        }
        
        dfs(result, new ArrayList<>(runningList), root.left, targetSum, sum);
        dfs(result, new ArrayList<>(runningList), root.right, targetSum, sum);
    
    }
}