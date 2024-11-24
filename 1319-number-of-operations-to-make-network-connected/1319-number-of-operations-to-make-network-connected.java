class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(n - 1 > connections.length) {
            return -1;
        }
        ArrayList<Integer>[] adj = new ArrayList[n]; //O(n)
        for(int i =0; i<n;i++) {        //O(n)
            adj[i] = new ArrayList<>(); // O(1)
        }
        for(int[] con : connections) {//O() lenght of conenction
            adj[con[0]].add(con[1]);
            adj[con[1]].add(con[0]);
        }
        boolean[] visited = new boolean[n]; // O(n)
        int count =0;//O(1)
        for(int i = 0; i < n; i++) { //O(n)
            if( !visited[i] ) {
               dfs(adj, i, visited);
                count++;
            }
            
        }
        return count -1;
    }
    //O(n*m) 
    
    void dfs(ArrayList<Integer>[] adj, int i, boolean[] visited) {
        if(visited[i]) {
            return;
        }
        visited[i] =true;
        for(int neighbours: adj[i]) {
            if(!visited[neighbours]) {
               dfs(adj, neighbours, visited); 
            }
        }
    }
}