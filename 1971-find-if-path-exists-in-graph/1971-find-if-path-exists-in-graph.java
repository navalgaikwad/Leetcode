class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n]; 
        ArrayList<Integer> adj[] = new ArrayList[n];
        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        //for(int i=0; i<n;i++ ) {
            if(dfs(adj, source, destination, visited)) {
                return true;
            }
       // }
        return false;
    }
    
    boolean dfs(ArrayList<Integer> adj[], int src, int dest, boolean[] visited) {
        if(src == dest) return true;
        visited[src] = true;
        for(int neighbour:adj[src]) {
            if(!visited[neighbour]) {
                if(dfs(adj, neighbour, dest, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}