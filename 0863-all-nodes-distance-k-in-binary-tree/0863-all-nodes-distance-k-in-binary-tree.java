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
    void buildTree(TreeNode child, TreeNode parent) {
        if(child==null) {
            return;
        }
        //check for key not present in map
        if(!map.containsKey(child.val)) {
            map.put(child.val, new ArrayList<>());
        }
        if(parent!=null) {
            map.get(parent.val).add(child.val);
            map.get(child.val).add(parent.val);
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
            for(Integer neighbour : map.get(next)) {
                if(!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    q.add(new int[]{neighbour, level+1});
                }
            }
        }
        return ans;
    }
}