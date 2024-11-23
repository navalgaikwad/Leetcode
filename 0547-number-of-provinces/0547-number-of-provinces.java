class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<Integer>adj[] = new ArrayList[n+1];
        for(int i=0; i<=n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<isConnected[0].length; j++) {
                if(isConnected[i][j] == 1) {
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }
        boolean[] visited = new boolean[n];
        int count =0;
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(adj, i, visited);
                count++;
            }
        }
        return count;
    }
    
    void dfs(ArrayList<Integer>adj[], int start, boolean[] visited) {
        visited[start] = true;
        for(Integer neighbour: adj[start]) {
            if(!visited[neighbour]) {
                dfs(adj, neighbour, visited);
            }
        }
    }
}