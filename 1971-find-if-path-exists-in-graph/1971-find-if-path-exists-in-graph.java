class Solution {
    public boolean validPath(int n, int[][] edges, int s, int d) {
        ArrayList<Integer> adj[] = new ArrayList[n];
        for(int i =0; i<n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] edge:edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        boolean[] viisted = new boolean[n];
        return dfs(adj, s, d, viisted);
    }
    
    boolean dfs(ArrayList<Integer> adj[], int source, int destination, boolean[] visited) {
        if(source == destination) {
            return true;
        }
        visited[source] = true; 
        for(int neighbour :adj[source]) {
            //int neighbour = edge[1];
            if(!visited[neighbour]) {
                if(dfs(adj, neighbour, destination, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}