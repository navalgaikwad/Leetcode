class Solution {
    List<List<Integer>>  result = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ArrayList<Integer> runingList = new ArrayList<>();
        //runingList.add(0);
        dfs(graph, 0, graph.length-1, runingList);
        return result;
    }
    void dfs(int[][] graph, int strt, int dest, List<Integer> runningList) {
        runningList.add(strt);
        if(strt == dest) {
            result.add(new ArrayList<>(runningList));
            return;
        }
        
        for(int  neighbour:graph[strt]) {
            dfs(graph, neighbour, dest, new ArrayList<>(runningList));
        }
    }
}