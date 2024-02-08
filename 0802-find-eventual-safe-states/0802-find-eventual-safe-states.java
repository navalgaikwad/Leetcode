class Solution {
    public List<Integer> eventualSafeNodes(int[][] graphs) {
        int n=graphs.length;
        ArrayList<Integer> adj[] = new ArrayList[n];
        for(int i=0;i<n; i++){
            adj[i] = new ArrayList<>();
        }
       for (int i = 0; i < n; i++) {
            for (int val : graphs[i]) {
                adj[i].add(val);
            
            }
        }
          List<Integer> answer = new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        int[] visited=new int[n];
        for(int i=0; i<n; i++){
            dfs(adj, i, visited, stack);
            
            
        }
          while(!stack.isEmpty()){
                  answer.add(stack.pop());
              }
        Collections.sort(answer);
        return answer;
        
    }
    
    boolean dfs(ArrayList<Integer>[] map, int node, int[] visited, Stack<Integer> stack){
        if(visited[node] == 1){
            return false;
        }
        if(visited[node] == 2){
            return true;
        }
        visited[node] = 1;
        for(Integer neighbour: map[node]){
            if(!dfs(map, neighbour, visited, stack)){
                return false;
            }
        }
          stack.push(node);
        visited[node] = 2;
      
        return true;
    }
}