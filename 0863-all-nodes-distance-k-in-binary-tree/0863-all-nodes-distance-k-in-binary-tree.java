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
        if (parent != null) {
            adjListMap.get(child.val).add(parent.val);
            adjListMap.get(parent.val).add(child.val);
        }
        buildList(child.left, child);
        buildList(child.right, child);
        
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        buildList(root, null);
       // System.out.print(adjListMap);
        List<Integer> result = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{target.val, 0});
        HashSet<Integer> visited = new HashSet<>();
        visited.add(target.val);
        
        while(!q.isEmpty()) {
            int[] current = q.remove();
            int src = current[0];
            int level = current[1];
            if(level == k) {
               result.add(src);
               //continue;
            }
            for(Integer neighbour: adjListMap.get(src)) {
                if(!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    q.add(new int[]{neighbour, level +1});
                }
            }
        }
      return result;
    }
}