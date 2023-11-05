class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
       ArrayList<Integer>adj[] = new ArrayList[n];
       for(int i=0; i<n; i++){
           adj[i] = new ArrayList<>();
       }
       for(int[] prerequisite:prerequisites){
           adj[prerequisite[1]].add(prerequisite[0]);
       }
        Boolean[] visited = new Boolean[n];
        for(int i=0; i<n; i++){
            if(!dfs(adj, i, visited)){
                return false;
            }
        }
        return true;
    }
    
    boolean dfs(ArrayList<Integer>adj[] , int i,  Boolean[] visited){
        if(visited[i] != null && visited[i] == false){
            return false;
        }
        if(visited[i] != null && visited[i] == true){
            return true;
        }
        visited[i] = false;
        
        for(Integer neighbour: adj[i]){
            if(!dfs(adj, neighbour, visited)){
                return false;
            }
        }
        visited[i] = true;
        return true;
    }
   
}