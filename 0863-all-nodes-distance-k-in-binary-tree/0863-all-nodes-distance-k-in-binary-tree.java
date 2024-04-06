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
    Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    void build(TreeNode root, TreeNode parent) {
        if(root == null) {
            return;
        }
        if(!map.containsKey(root.val)) {
            map.putIfAbsent(root.val, new ArrayList<>());
            
        }
        if(parent != null) {
            map.get(root.val).add(parent.val);
            map.get(parent.val).add(root.val);
        } 
        
        build(root.left, root);
        build(root.right, root);
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        build(root, null);
        
        Queue<int[]> q= new LinkedList<>();
        
        HashSet<Integer> visited = new HashSet<>();
        
        List<Integer> ans = new ArrayList<>();
        
        q.add(new int[]{target.val, 0});
        visited.add(target.val);
        while(!q.isEmpty()) {
            
            int[] current = q.remove();
            int currentValue = current[0];
            int dist = current[1];
            
            if(dist == k) {
                ans.add(currentValue);
                continue;
            } 
            for(Integer neighbour: map.get(currentValue)) {
                if(!visited.contains(neighbour)) {
                    q.add(new int[]{neighbour, dist + 1 });
                    visited.add(neighbour);
                }
            }
        }
        return ans;
    }
}
/*
1: 0, 8, 3
5: 2,6, 3


*/