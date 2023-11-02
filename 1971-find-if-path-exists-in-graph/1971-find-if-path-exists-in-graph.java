class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
       ArrayList<Integer> adj[] = new ArrayList[n];
       for(int i=0; i<n; i++){
           adj[i] = new ArrayList<>();
       }
       for(int[] edge: edges){
          adj[edge[0]].add(edge[1]); 
          adj[edge[1]].add(edge[0]); 
       }
      boolean[] visited = new boolean[n];
      return helper(adj, source, destination, visited);
    }
    
    boolean helper(ArrayList<Integer> adj[],  int source, int destination, boolean[] visited){
        if(source == destination){
            return true;
        }
        visited[source] = true;
        for(Integer neighbour: adj[source]){
            if(!visited[neighbour] ){
              if(helper(adj, neighbour, destination, visited)){
                  return true;
              }  
            }
        }
     return false;
    }
}