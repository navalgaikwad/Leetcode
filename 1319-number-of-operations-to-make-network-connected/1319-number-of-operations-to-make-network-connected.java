class Solution {
   
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
    ArrayList<Integer>adj[] = new ArrayList[n];
        for(int i=0;i<n;i++){
        adj[i]=new ArrayList<>();    
        }
        for(int[] connection:connections){
            adj[connection[0]].add(connection[1]);
            adj[connection[1]].add(connection[0]);
        }
        int count=0;
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
               dfs(adj, i, visited);  
                count++;
            }
           
        }
        return count-1;
    }
    
    void dfs(ArrayList<Integer> adj[], int src, boolean[] visited){
        visited[src]=true;
        for(Integer neighbour: adj[src]){
            if(!visited[neighbour]){
                dfs(adj, neighbour, visited );
            }
        }
    }
    
}