class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int target = graph.length - 1;
        
        helper(graph, target, 0, new ArrayList<>());
        return result;
    }
    
    void helper(int[][] graph, int target, int src, List<Integer> ans){
        
        ans.add(src);
        
        if(src == target){
          result.add(new ArrayList<>(ans));  
          return;
        }
        
        for(Integer neighbour: graph[src]){
            
           helper(graph, target, neighbour , new ArrayList<>(ans));
           //ans.remove(ans.size() - 1); By backtracking
           // new ArrayList<>(ans) to copy at stack
        }
    }
}