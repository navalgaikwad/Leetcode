import java.util.ArrayList;

class Solution {
    public int minScore(int n, int[][] roads) {
        ArrayList<int[]> adj[] = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] road : roads) {
            adj[road[0]].add(new int[]{road[1], road[2]});
            adj[road[1]].add(new int[]{road[0], road[2]});
        }
        
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        return dfs(adj, 1, visited);
    }
    

    int dfs(ArrayList<int[]> adj[], int parent, boolean[] visited) {
        int total = Integer.MAX_VALUE;

        for(int[] neighbours : adj[parent]) {
            int neighbour = neighbours[0];
            int cost = neighbours[1];
             total = Math.min(total, cost);
            if (!visited[neighbour]) {
                visited[neighbour] = true; 
                int min = dfs(adj, neighbour, visited);
                total = Math.min(total, min); 
            }
        }
       
        return total;
    }
}
