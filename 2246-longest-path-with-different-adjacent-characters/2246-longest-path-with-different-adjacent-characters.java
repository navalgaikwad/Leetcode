class Solution {
    int diameter = 0;
    public int longestPath(int[] parent, String s) {
        int len = parent.length;
        ArrayList<Integer> adj[] = new ArrayList[len];
        for(int i=0; i<len; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i=0; i<len; i++) {
            if(parent[i] != -1) {
                adj[parent[i]].add(i);
            }
        }
        boolean[] visited = new boolean[len];
        dfs(adj, 0, s, visited);
        return diameter;
    }
    
    int dfs(ArrayList<Integer> adj[], int parent, String s, boolean[] visited) {
        int first = 0; int second = 0;
        visited[parent] = true;
        for(Integer neighbour:adj[parent]) {
            if(!visited[neighbour]) {
                int count = dfs(adj, neighbour, s, visited);
                if(s.charAt(neighbour)!=s.charAt(parent)) {
                    if(first < count) {
                        second = first;
                        first = count;
                    }else if(second < count) {
                        second = count;
                    }
                }
                
            }
            
        }
        diameter = Math.max(first + second + 1, diameter);
        return 1 + first;
    }
}