class Solution {
    long diameter = 0;
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length;
        ArrayList<Integer> adj[] = new ArrayList[n + 1];
        for(int i=0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] road : roads) {
            adj[road[0]].add(road[1]);
            adj[road[1]].add(road[0]);
        }
        boolean[] visited = new boolean[n + 1];
        //visited[0] = true;
        dfs(adj, 0, visited, seats);
        return diameter;
    }
    long dfs(ArrayList<Integer> adj[], int parent, boolean[] visited,  int seats) {
        int total = 1;
        visited[parent] = true;
        for(Integer neighbour : adj[parent]) {
            if(!visited[neighbour]) {
                total+= dfs(adj,neighbour, visited, seats);
            }
        }
        if(parent != 0) {
            diameter+= Math.ceil((double)total/(double)seats);   
        }
        return total;
    }
}