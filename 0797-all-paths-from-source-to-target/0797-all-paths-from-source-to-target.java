class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(graph, 0, new ArrayList<>());
        return result;
    }
    
    void dfs(int[][] graph, int parent, ArrayList<Integer> ans) {
        ans.add(parent);
        if(parent == graph.length-1) {
            result.add(new ArrayList<>(ans));
            return;
        }
         
        for(Integer neighbour: graph[parent]) {
            //if(neighbour!=parent) {
                dfs(graph, neighbour, new ArrayList<>(ans));
           // }
        }
        
    }
}