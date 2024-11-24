class Solution {
    public int minReorder(int n, int[][] connections) {
        ArrayList<int[]> adj[] = new ArrayList[n];
        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] connection:connections) {
            adj[connection[0]].add(new int[]{connection[1], 1});
            adj[connection[1]].add(new int[]{connection[0], 0});
        }
        return dfs(adj, 0, -1);
    }
    
    int dfs(ArrayList<int[]> adj[], int start, int parent) {
        int total = 0;
        for(int[] neighbour: adj[start]) {
            if(neighbour[0]!=parent) {
                total+=neighbour[1] + dfs(adj, neighbour[0], start);
            }
            
        }
        return total;
    }
}