class Solution {
    public boolean canFinish(int numCourses, int[][] pre) {
        int len = numCourses;
        ArrayList<Integer>adj[] = new ArrayList[numCourses];
        for(int i=0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] p : pre) {
            adj[p[1]].add(p[0]);
        }
        int[] visited  = new int[numCourses];
        for(int i=0; i<numCourses; i++) {
            //if(visited[i] == 0) {
                if(!dfs(adj, i, visited)) {
                    return false;
                }
            //}
        }
        return true;
    }
    boolean dfs(ArrayList<Integer>adj[], int parent, int[] visited) {
        if(visited[parent] == 1) {
            return false;
        }
        if(visited[parent] == 2) {
            return true;
        }
        visited[parent] = 1;
        for(Integer neighbour : adj[parent]) {
            if(!dfs(adj, neighbour, visited)) {
                return false;
            }
        }
        visited[parent] = 2;
        return true;
    }
}