class Solution {
    int maxTime =0;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<Integer> adj[] = new ArrayList[n];
        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i=0; i<n; i++) {
            if(manager[i]!=-1) {
               adj[manager[i]].add(i); 
            }
        }
        
        dfs(adj, headID, informTime, 0);
        return maxTime;
    }
    
    void dfs(ArrayList<Integer> adj[], int parent, int[] informTime, int time) {
        
        for(int neighbour :adj[parent]) {
            dfs(adj, neighbour, informTime, time + informTime[parent]);
        }
        maxTime = Math.max(maxTime, time);
    }
}