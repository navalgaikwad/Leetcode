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
    void helper(TreeNode parent, TreeNode child) {
        if(child == null) {
            return;
        }
        if(!adj.containsKey(child.val)) {
            adj.put(child.val, new ArrayList<>());
        }
        if(parent!=null) {
            adj.get(parent.val).add(child.val);
            adj.get(child.val).add(parent.val);
        }
        helper(child, child.left);
        helper(child, child.right);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        helper(null, root);
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        set.add(target.val);
        queue.add(new int[]{target.val, 0});
        ArrayList<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()) {
            int[] array = queue.remove();
            int current = array[0];
            int level = array[1];
            if(level == k) {
                ans.add(current);
            }
            for(Integer neighbours: adj.get(current)) {
                if(!set.contains(neighbours) && level <= k) {
                    set.add(neighbours);
                    queue.add(new int[]{neighbours, level + 1});
                }
            }
        }
        return ans;
    }
}