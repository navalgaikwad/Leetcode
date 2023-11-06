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


    private void buildAdjList(TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }

        if (!adjListMap.containsKey(node.val)) {
            adjListMap.put(node.val, new ArrayList<>());
        }
        if (parent != null) {
            adjListMap.get(node.val).add(parent.val);
            adjListMap.get(parent.val).add(node.val);
        }

        buildAdjList(node.left, node);
        buildAdjList(node.right, node);
    }

    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        buildAdjList(root, null);
        List<Integer> result = new ArrayList<>();
        k = k ;
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[]{target.val, 0});
        HashSet<Integer> set = new HashSet<>();
        set.add(target.val);
        while(!queue.isEmpty()){
            int[] current = queue.remove();
            int src = current[0];
            int level = current[1];
            if(level == k){
               result.add(src);
               continue;
            }
            for(Integer neighbour: adjListMap.get(src)){
                if(!set.contains(neighbour) && level <=k){
                   queue.add(new int[]{neighbour, level + 1}); 
                   set.add(neighbour);
                }
            }
        }
        
       // System.out.print(adjListMap);
        return result;
    }
}