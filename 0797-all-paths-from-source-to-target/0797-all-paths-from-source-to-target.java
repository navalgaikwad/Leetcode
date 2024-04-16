class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
       // int 
        helper(graph, 0, new ArrayList<>(), graph.length - 1);
        return result;
    }
    void helper(int[][] graph, int parent, ArrayList<Integer> ans, int target) {
        ans.add(parent);
        if(parent == target) {
            result.add(new ArrayList<>(ans));
            return;
        }
        for(int neighbour : graph[parent]) {
            helper(graph, neighbour, new ArrayList<>(ans), target);
        }
    }
}