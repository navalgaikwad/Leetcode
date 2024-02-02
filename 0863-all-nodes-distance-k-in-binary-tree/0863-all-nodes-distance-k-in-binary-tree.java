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
     private Map<Integer, ArrayList<Integer>> adjListMap = new HashMap<>();
    void buildList(TreeNode child, TreeNode parent) {
        if(child == null) {
            return;
        }
        if(!adjListMap.containsKey(child.val)) {
            adjListMap.put(child.val, new ArrayList<>());
        } 
        if(parent!=null) {
            adjListMap.get(child.val).add(parent.val);
            adjListMap.get(parent.val).add(child.val);
        }
        
        buildList(child.left, child);
        buildList(child.right, child);
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        buildList(root, null);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{target.val, 0});
        HashSet<Integer> visited = new HashSet<>();
        visited.add(target.val);
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            int[] current = q.remove();
            int level = current[1];
            int dest = current[0];
            if(level == k) {
                ans.add(dest);
                continue;
            }
            for(Integer neighbour: adjListMap.get(dest)) {
                if(!visited.contains(neighbour)) {
                    q.add(new int[]{neighbour, level+1});
                    visited.add(neighbour);
                }
            }
        }
        return ans;
    }
}