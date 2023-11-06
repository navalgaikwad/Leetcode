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

    //convert TrreeNode to adjacencyList save parent and child
    //created adajcency list
    private void buildAdjList(TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }
        //check value is present in map
        if (!adjListMap.containsKey(node.val)) {
            adjListMap.put(node.val, new ArrayList<>());
        }
        //if parent is not null intitally it is null
        if (parent != null) {
            //bi - directional account save parent account 
            adjListMap.get(parent.val).add(node.val);
            adjListMap.get(node.val).add(parent.val);
           
        }
        //left
        buildAdjList(node.left, node);
        //right
        buildAdjList(node.right, node);
    }

    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        buildAdjList(root, null);
        List<Integer> result = new ArrayList<>();
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
        
        return result;
    }
}