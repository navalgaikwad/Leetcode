class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n =numCourses;
        int[] visited = new int[n];
        ArrayList<Integer>adj[] = new ArrayList[n];
        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int[] pre: prerequisites){
            adj[pre[0]].add(pre[1]);
        }
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            if(!dfs(adj, i, visited, st)){
                return new int[]{};
            }
        }
        int[] ans = new int[n];
        int i = 0;
        for(Integer s: st){
            ans[i++] = s;
        }
        return ans;
      
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