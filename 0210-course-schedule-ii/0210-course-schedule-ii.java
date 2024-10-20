class Solution {
       public int[] findOrder(int numCourses, int[][] pres) {
         // if(numCourses>1&&pres.length==0){
         //    int[] val= new int[numCourses];
         //     val[0]=1;
         //     val[1]=0;
         //     return val;
         // }
        ArrayList<Integer>[]adj=new ArrayList[numCourses];
        for(int i=0;i<numCourses; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] pre: pres){
            adj[pre[1]].add(pre[0]);
        }

        int[] ans = new int[numCourses];
        int[] visited=new int[numCourses];
        Stack<Integer> stack=new Stack<>();
        for (int i=0; i< numCourses; i++){
           if(!dfs(adj, stack, i, visited)){
                 return new int[]{};
           }
        }
        
        int i = 0;
        while (!stack.isEmpty()) {
            ans[i++] = stack.peek();
            stack.pop();
        }
        return ans;
    }
    
  boolean dfs(ArrayList<Integer>[]adj,Stack<Integer> stack, int node, int[] visited){
        if(visited[node]==1) {
            return false;
        }
        if(visited[node]==2){
            return true;
        }
        visited[node]=1;

        for(int neighbour: adj[node]){
           
                if (!dfs(adj, stack, neighbour, visited)){
                    return false;
                }
            
        }
        stack.push(node);
        visited[node] = 2;

        return true;

    }
    
}