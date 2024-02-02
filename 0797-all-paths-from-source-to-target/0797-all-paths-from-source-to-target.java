class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        helper(graph, 0, graph.length - 1, new ArrayList<>());
        return result;
    }
    
    void helper(int[][] graph, int start, int target, List<Integer> runnningList) {
        runnningList.add(start);
        if(start == target) {
            result.add(new ArrayList<>(runnningList));
        }
        
        for(int neighbour: graph[start]) {
            helper(graph, neighbour, target, new ArrayList<>(runnningList));
        }
    }
}