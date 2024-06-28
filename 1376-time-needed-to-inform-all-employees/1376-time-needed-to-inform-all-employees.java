class Solution {
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
        boolean[] visited = new boolean[n];
        return helper(adj, headID, informTime, visited);
    }
    int helper(ArrayList<Integer> adj[], int parent, int[] informTime, boolean[] visited) {
        visited[parent] = true;
        int total = 0;
        for(Integer neighbour : adj[parent]) {
            if(!visited[neighbour]) {
                int totalChildTime = helper(adj, neighbour, informTime, visited);
                total = Math.max(total, totalChildTime + informTime[parent]);
            }
        }
        return total;
    }
}