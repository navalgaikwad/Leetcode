class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
       ArrayList<Integer>adj[] = new ArrayList[n];
       for(int i=0; i<n; i++){
           adj[i] = new ArrayList<>();
       }
       for(int[] prerequisite:prerequisites){
           adj[prerequisite[1]].add(prerequisite[0]);
       }
        int[] visited = new int[n];
        for(int i=0; i<n; i++){
            if(!dfs(adj, i, visited)){
                return false;
            }
        }
        return true;
    }
    
    boolean dfs(ArrayList<Integer>adj[] , int i,  int[] visited){
        if(visited[i] == 1){
            return false;
        }
        if(visited[i] == 2){
            return true;
        }
        visited[i] = 1;
        for(Integer neighbour: adj[i]){
            if(!dfs(adj, neighbour, visited)){
                return false;
            }
        }
        visited[i] = 2;
        return true;
    }
   
}