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
        if(child == null) return;
        
        if (!adj.containsKey(child.val)) {
            adj.put(child.val, new ArrayList<>());
        }
        
        if(parent != null) {
            adj.get(parent.val).add(child.val);
            adj.get(child.val).add((parent.val));
        }
        buildTree(child.left, child);
        buildTree(child.right, child);
        
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        buildTree(root, null);
        List<Integer> result = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{target.val, 0});
        HashSet<Integer> visited = new HashSet<>();
        visited.add(target.val);
        //List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            int size = queue.size();
           
                int[] current = queue.remove();
                int x = current[0];
                int count = current[1];
                
                if(count == k) {
                    result.add(x);
                }
            for(Integer neighbour : adj.get(x)) {
                if(!visited.contains(neighbour)) {
                    queue.add(new int[]{neighbour, count+1});
                    visited.add(neighbour);
                }
            }
        }
        return result;
    }
}