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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        TreeSet<Integer> set = new TreeSet<>();
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, set);
        
        for(Integer query:queries) {
            List<Integer> list = new ArrayList<>();
            Integer min = set.floor(query);
            Integer max = set.ceiling(query);
            list.add(min == null ? -1 : min);
            list.add(max == null ? -1 : max);
            result.add(list);
        }
        return result;
    }
    
    void dfs(TreeNode root, TreeSet<Integer> set) {
        if(root == null) return;
        dfs(root.left, set);
        set.add(root.val);
        dfs(root.right, set);
    }
}