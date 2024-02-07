class Solution {

    
    int[] parent = null;
    int[] distFromRoot = null;

  void  dfs(List<Integer>adj[], int curr, int par, int dist){
        distFromRoot[curr] = dist;
        parent[curr]=par;
        for(Integer neighbour: adj[curr]){
            if(neighbour!=par){
               dfs(adj, neighbour, curr, dist+1 ); 
            }
        }
    }
    
   int maxSum(List<Integer>adj[], int[] amount, int curr, int parent){
        int amt= amount[curr];
        int max = Integer.MIN_VALUE;
       for(Integer neigbour: adj[curr]){
           if(neigbour != parent){
             max=Math.max(max, maxSum(adj, amount, neigbour, curr));
           }
       }
       if(max == Integer.MIN_VALUE){
           return amt;
       }
       return max +amt;
    }
    
    
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
      List<Integer>adj[] = new ArrayList[edges.length+1];
        distFromRoot = new int[edges.length+1];
        parent = new int[edges.length+1];
      for(int i=0;i<edges.length+1; i++){
          adj[i]=new ArrayList<>();
          
      }
      for(int[] edge: edges){
          adj[edge[0]].add(edge[1]);
          adj[edge[1]].add(edge[0]);
      }
        
      dfs(adj, 0, 0, 0);
     int bobSide=bob; int bobDist=0;
     while(bobSide!=0){
         if(distFromRoot[bobSide] > bobDist ){
             amount[bobSide] = 0;
         }else if(distFromRoot[bobSide] == bobDist){
             amount[bobSide]=amount[bobSide]/2;
         }
         bobSide=parent[bobSide];
         bobDist++;
     }
        
        return maxSum(adj, amount, 0, 0);
    }
}