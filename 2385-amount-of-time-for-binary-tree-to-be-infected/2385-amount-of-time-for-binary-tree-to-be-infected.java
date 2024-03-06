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
    Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
    
    void build(TreeNode child, TreeNode parent) {
        if(child == null) {
            return;
        }
        if(!adj.containsKey(child.val)) {
            adj.put(child.val, new ArrayList<>());
        }
        
        if(parent!=null) {
            adj.putIfAbsent(child.val, new ArrayList<>());
            adj.putIfAbsent(parent.val, new ArrayList<>());
            adj.get(parent.val).add(child.val);
            adj.get(child.val).add(parent.val);
        }
        build(child.left, child);
        build(child.right, child);
        
    }
    public int amountOfTime(TreeNode root, int start) {
        build(root, null);
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});
        HashSet<Integer> visited = new HashSet<>();
        visited.add(start);
        int max = 0;
        while(!q.isEmpty()) {
            int[] current = q.remove();
            int src = current[0];
            int level = current[1];
            max = Math.max(level, max);
            for(Integer neighbour :adj.get(src)) {
                if(!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    q.add(new int[]{neighbour, level+1});
                }
            }
        }
        return max;
    }
}