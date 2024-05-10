class Solution {
    Stack<Integer> ans = new Stack<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> adj[] = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] prerequisite:prerequisites) {
            adj[prerequisite[1]].add(prerequisite[0]);
        }
        int[] visited = new int[numCourses];
         for (int i=0; i< numCourses; i++){
           if(!dfs(adj, i, visited)){
                 return new int[]{};
           }
        }
         int i = 0;
        int[] result = new int[numCourses];
        while (!ans.isEmpty()) {
            result[i++] = ans.peek();
            ans.pop();
        }
        return result;
    }
    boolean dfs(ArrayList<Integer> adj[], int parent, int[] visited) {
        if(visited[parent] == 1) {
            return false;
        }
        if(visited[parent] == 2) {
            return true;
        }
        visited[parent] = 1;
        for(Integer neighbour :adj[parent]) {
            if(!dfs(adj, neighbour, visited)) {
                return false;
            }
        }
        visited[parent] = 2;
        ans.push(parent);
        return true;
    }
}