/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
    void buildTree(TreeNode child, TreeNode parent) {
        //if child is null
        //parent is not null
        //left ani right
        if(child == null) {
            return;
        }
        if(!adj.containsKey(child.val)) {
            adj.put(child.val, new ArrayList<>());
        }
        if(parent != null) {
            adj.get(parent.val).add(child.val);
            adj.get(child.val).add(parent.val);
        }
        buildTree(child.left, child);
        buildTree(child.right, child);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        buildTree(root, null);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{target.val, 0});
        Set<Integer> visited = new HashSet<>();
        visited.add(target.val);
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            int[] current = q.remove();
            int next = current[0];
            int level = current[1];
            if(level == k) {
               ans.add(next); 
            }
            for(Integer neighbour : adj.get(next)) {
                if(!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    q.add(new int[]{neighbour, level+1});
                }
            }
        }
        return ans;
    }
}