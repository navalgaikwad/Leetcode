class Solution {
    // 
    public boolean validPath(int n, int[][] edges, int s, int d) {
        if(edges.length == 0)
            return true;
        ArrayList<Integer>[] map = new ArrayList[n];
    
        boolean[] visited=new boolean[n];
        for(int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        
        for(int[] edge: edges) {
            map[edge[0]].add(edge[1]);
            map[edge[1]].add(edge[0]);
        }
        
        Queue<Integer> q=new LinkedList<>();
        q.offer(s);
        visited[s]=true;
        while(!q.isEmpty()){
           int curr = q.poll();
            
           if(curr == d){
               return true;
           }else{
               for(int nei: map[curr]){
                   if(!visited[nei]) {
                       q.add(nei);
                       visited[nei] = true; 
                   }
               }

           }
       }
       return false;      
}
    
//     boolean dfs(Map<Integer,ArrayList<Integer>>map, boolean[] v,int s, int d){
//         if(s==d) return true;
//         if(v[s]){
//             return false;
//         }
//        // v.add(s, 1);
//         v[s]=true;
        
//         for(int i=0;i<map.get(s).size();i++){
//             if(dfs(map, v, map.get(s).get(i), d)){
//                 return true;
//             }
//         }
        
//         return false;
//     }
    
}