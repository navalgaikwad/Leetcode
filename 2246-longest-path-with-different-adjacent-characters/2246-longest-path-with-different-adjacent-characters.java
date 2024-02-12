class Solution {
    int diameter =0;
    public int longestPath(int[] parent, String s) {
        int len = parent.length;
        ArrayList<Integer>[] adj = new ArrayList[len];
        for (int i = 0; i < len; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < len; i++) {
            if (parent[i] != -1) {
                adj[parent[i]].add(i);
            }
        }
        boolean[] visited = new boolean[len];
        dfs(adj, 0, s, visited);
        return diameter;
    }
    
    int dfs(ArrayList<Integer>[] adj, int parent, String s, boolean[] visited ) {
        int left = 0; int right = 0;
        visited[parent] = true;
        for(Integer neighbour : adj[parent]) {
            if(!visited[neighbour]) {
                int count = dfs(adj, neighbour, s, visited);
                if (s.charAt(parent) != s.charAt(neighbour)) {
                if(left < count) {
                    right = left;
                    left = count;
                }else if(right< count) {
                    right = count;
                }
            }
          }
        }
        
        diameter = Math.max(diameter, left + 1 + right);
        return 1 + left;
    }
    
}

//find the daimenter
//left