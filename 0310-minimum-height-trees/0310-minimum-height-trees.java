class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
     List<Integer> []adj =new ArrayList[n];
     int indirect[] = new int[n];
          List<Integer> result=new ArrayList<>();
          if(edges.length==0){
            result.add(0);
           return result; 
        } 
        for(int i=0; i<n; i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] edge: edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
            indirect[edge[0]]++;
            indirect[edge[1]]++;
            
        }
        Queue<Integer> q= new LinkedList<>();
        
        for(int i=0;i<n;i++){
            if(indirect[i] ==1){
                 q.add(i);
            }
        }
      
        while(!q.isEmpty()){
            int size = q.size();
            result.clear();
            for(int i=0; i<size; i++){
                 int curr = q.remove();
                for(Integer neighbour: adj[curr]){
                    indirect[neighbour]--; 
                    if(indirect[neighbour]==1){
                        q.add(neighbour);
                }
              }
                 result.add(curr);           
            }
        }
        return result;
    }
}