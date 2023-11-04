class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n =numCourses;
        int[] visited = new int[n];
        ArrayList<Integer>adj[] = new ArrayList[n];
        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int[] pre: prerequisites){
            adj[pre[1]].add(pre[0]);
        }
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            if(!dfs(adj, i, visited, stack)){
                return new int[]{};
            }
        }
       int[] order = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            order[i] = stack.pop();
        }
        return order;
      
    }
    boolean dfs(ArrayList<Integer>adj[], int i, int[] visited, Stack<Integer> stack ){
        if(visited[i] == 1){
           return false;
        }
        if(visited[i] == 2){
           return true;
        }
        visited[i] = 1;
       
        for(Integer neighbour: adj[i]){
            if(!dfs(adj, neighbour, visited, stack)){
                return false;
            }
        }
        
        visited[i] = 2;
        stack.push(i);
        return true;
    }
}

// class Solution {
//     public int[] findOrder(int numCourses, int[][] prerequisites) {
//         List<Integer>[] adj = new ArrayList[numCourses];
//         for(int i = 0; i < numCourses; i++){
//             adj[i] = new ArrayList<>();
//         }
        
//         for(int[] pre: prerequisites){
//             adj[pre[1]].add(pre[0]);
//         }
        
//         Stack<Integer> stack = new Stack<>();
//         int[] visited = new int[numCourses];
//         for(int i = 0; i < numCourses; i++){
//             if(visited[i] == 0){
//                 if(!dfs(adj, i, visited, stack)){
//                     return new int[]{};
//                 }
//             }
//         }
        
//         int[] order = new int[numCourses];
//         for(int i = 0; i < numCourses; i++){
//             order[i] = stack.pop();
//         }
//         return order;
//     }
    
//     boolean dfs(List<Integer>[] adj, int course, int[] visited, Stack<Integer> stack) {
//         if(visited[course] == 1){
//             return false; // Cycle detected.
//         }
//         if(visited[course] == 2){
//             return true; // Already visited and processed.
//         }
        
//         visited[course] = 1; // Mark the current course as being visited.
        
//         for(int neighbour: adj[course]){
//             if(!dfs(adj, neighbour, visited, stack)){
//                 return false; // Cycle detected in the DFS path.
//             }
//         }
        
//         visited[course] = 2; // Mark the current course as fully visited.
//         stack.push(course); // Add the course to the stack which represents the order.
//         return true;
//     }
// }
