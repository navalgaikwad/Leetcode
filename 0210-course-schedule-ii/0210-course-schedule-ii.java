class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n =numCourses;
        int[] visited = new int[n];
        int[] indegree = new int[n];
        ArrayList<Integer>adj[] = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int[] pre: prerequisites){
            adj[pre[1]].add(pre[0]);
            indegree[pre[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<n ;i++){
            if(indegree[i] == 0){
               queue.add(i); 
            }
        }
        
        int[] result = new int[n];
        List<Integer> list = new ArrayList<>();
        int i =0;
        while(!queue.isEmpty()){
            
            int current = queue.remove();
            list.add(current);
            
            for(Integer neighbour: adj[current]){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    queue.add(neighbour);
                }
            }
        }
  
        if(list.size() != n ){
           return new int[0];
        }else{
            for(Integer li: list){
               result[i++]= li; 
            }
        }
       
      return result;
    }
}
   