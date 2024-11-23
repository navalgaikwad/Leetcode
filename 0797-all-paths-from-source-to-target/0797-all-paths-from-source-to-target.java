class Solution {
    List<List<Integer>>  result = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ArrayList<Integer> runingList = new ArrayList<>();
        runingList.add(0);
        dfs(graph, 0, graph.length-1, runingList);
        return result;
    }
    void dfs(int[][] graph, int strt, int dest, List<Integer> runningList) {
       
        if(strt == dest) {
            result.add(new ArrayList<>(runningList));
            return;
        }
        
        for(int  neighbour:graph[strt]) {
            runningList.add(neighbour);
            dfs(graph, neighbour, dest, runningList);
            runningList.remove(runningList.size()-1);
        }
    }
}