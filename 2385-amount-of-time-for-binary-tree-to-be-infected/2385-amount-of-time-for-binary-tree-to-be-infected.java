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
    void buildAdjList(TreeNode children, TreeNode parent) {
        if(children == null) {
            return;
        }
        
        if(!adj.containsKey(children.val)) {
            adj.putIfAbsent(children.val, new ArrayList<>());
        }
        
        if(parent != null) {
            adj.get(children.val).add(parent.val);
            adj.get(parent.val).add(children.val);
        }
        buildAdjList(children.left, children);
        buildAdjList(children.right, children);
    }
    public int amountOfTime(TreeNode root, int start) {
        buildAdjList(root, null);
        System.out.print(adj);
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(new int[]{start, 0});
        visited.add(start);
        int maxTime = 0;
      
        while(!q.isEmpty()) {
            int[] current = q.remove();
            int parent = current[0];
            int time = current[1];
            maxTime = Math.max(maxTime, time);
            for(Integer neighbour: adj.get(parent)) {
                if(!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    q.add(new int[]{neighbour, time + 1});
                }
            }
        }
        return maxTime;
    }
}