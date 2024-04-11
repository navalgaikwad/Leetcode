class Solution {
    Stack<Integer> st = new Stack<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> adj[] = new ArrayList[numCourses];
        for(int i =0; i<numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] pre : prerequisites) {
            adj[pre[1]].add(pre[0]);
        }
        int[] visited = new int[numCourses ];
        int[] ans = new int[numCourses];
       for (int i=0; i< numCourses; i++){
           if(!dfs(adj, i, visited)){
                 return new int[]{};
           }
        }
        int i = 0;
        while (!st.isEmpty()) {
            ans[i++] = st.peek();
            st.pop();
        }
        return ans;
    }
    boolean dfs(ArrayList<Integer> adj[], int parent, int[] visited) {
        if(visited[parent] == 1) {
            return false;
        } 
        if(visited[parent] == 2) {
            return true;
        }
        visited[parent] = 1;
        for(Integer neigbhour : adj[parent]) {
            if(!dfs(adj, neigbhour, visited)) {
                return false;
            }
        }
        visited[parent] = 2;
        st.push(parent);
        return true;
    }
}