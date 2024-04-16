class Solution {
    public int minReorder(int n, int[][] con) {
        ArrayList<int[]> adj[] = new ArrayList[n];
        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] c : con) {
            adj[c[0]].add(new int[]{c[1], 1});
            adj[c[1]].add(new int[]{c[0], 0});
        }
        return dfs(adj, 0, new HashSet<>());
    }
    
    int dfs(ArrayList<int[]> adj[], int parent, HashSet<Integer> visited) {
        int total = 0;
        visited.add(parent);
        for(int[] neighbours: adj[parent]) {
            int neighbour = neighbours[0];
            if(!visited.contains(neighbour)) {
                int cost = neighbours[1];
                total+= cost + dfs(adj, neighbour, visited);
           
            }
            
        }
        return total;
    }
}