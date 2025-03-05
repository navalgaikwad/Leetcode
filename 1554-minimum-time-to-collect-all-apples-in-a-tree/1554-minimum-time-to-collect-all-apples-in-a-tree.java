class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<Integer> adj[] = new ArrayList[n];
        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        return dfs(adj, 0, visited, hasApple);
    }
    int dfs(ArrayList<Integer> adj[], int start,boolean[] visited, List<Boolean> hasApple) {
        visited[start] = true;
        int total = 0;
        for(Integer neighbour : adj[start]) {
            if(!visited[neighbour]) {
                total+=dfs(adj, neighbour, visited, hasApple);
            }
        }
        if((start!=0)  && (hasApple.get(start) || total !=0 )) {
            total+=2;
        }
        return total;
    }
}