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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        helper(root, 0, 0);
        List<List<Integer>> result = new ArrayList<>();
        for(ArrayList<int[]> li : map.values()) {
            List<Integer> ans = new ArrayList<Integer>();
            Collections.sort(li, (a,b)->a[0] - b[0]);
            for(int[] l:li) {
                ans.add(l[1]);
            }
            result.add(ans);
        }
        return result;
    }
    
    void helper(TreeNode root, int dept, int index) {
        if(root == null) return;
        
       if(!map.containsKey(index)) {
            map.put(index, new ArrayList<>());
        }
         map.get(index).add(new int[]{dept, root.val});
        helper(root.left, dept + 1, index - 1);
        helper(root.right, dept + 1, index + 1);
    }
}