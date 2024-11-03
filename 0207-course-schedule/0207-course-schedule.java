class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
      ArrayList<Integer> adj[] = new ArrayList[numCourses + 1];
        for(int i=0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] prerequisite:prerequisites) {
            adj[prerequisite[0]].add(prerequisite[1]);
        }
        int[] visited = new int[numCourses+1];
        for(int i=0; i<numCourses; i++) {
            //if(visited[i] == 0) {
                if(!helper(adj, i, visited)) {
                    return false;
                }
            //}
        }
        return true;
        
        
    }
    
    boolean helper(ArrayList<Integer> adj[], int start, int[] visited) {
        if(visited[start] == 2) {
            return true;
        }
        if(visited[start] == 1) {
            return false;
        }
        visited[start] = 1;
        for(Integer neighbour : adj[start]) {
            if(!helper(adj, neighbour, visited)) {
                return false;
            }
        }
        visited[start] = 2;
        return true;
    }
}