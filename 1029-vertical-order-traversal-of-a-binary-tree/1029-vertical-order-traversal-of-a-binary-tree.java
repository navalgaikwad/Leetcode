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
    Map<Integer, ArrayList<int[]>> map = new TreeMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        List<List<Integer>> result = new ArrayList<>();
        for(ArrayList<int[]> list: map.values()) {
           Collections.sort(list, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
            ArrayList<Integer> current = new ArrayList<>();
            for(int[] num :  list) {
                current.add(num[1]);
            }
            result.add(current);
        }
        return result;
        
    }

    
    void dfs(TreeNode root, int index, int dept) {
        if(root == null) {
            return;
        }
        map.putIfAbsent(index, new ArrayList<>());
        map.get(index).add(new int[]{dept, root.val});
        dfs(root.left, index - 1, dept + 1);
        dfs(root.right, index + 1, dept + 1);
    }
}