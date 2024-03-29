class Solution {
    int count = 0;
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
     ArrayList<Integer> [] adj =new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j] == 1 && i != j){
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }
        int count=0;
        boolean[] visited=new boolean[n];
        for(int i=0;i<n; i++){
                if(!visited[i]){
                    dfs(adj, visited, i);
                    count++;
                }
            
        }
        return count;
    }
    
    void dfs(ArrayList<Integer> adj[], boolean[] visited, int src){
        visited[src]=true;
        for(Integer neighbour: adj[src]){
            if(!visited[neighbour]){
                dfs(adj, visited, neighbour);
            }
            
        }
    }    
}