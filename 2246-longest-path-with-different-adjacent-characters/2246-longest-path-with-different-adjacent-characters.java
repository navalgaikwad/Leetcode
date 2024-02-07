import java.util.ArrayList;

class Solution {
    int diameter = 0;
    
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
        dfs(adj, 0, visited, s);
        return diameter;
    }

    int dfs(ArrayList<Integer>[] adj, int parent, boolean[] visited, String s) {
        int longestPath1 = 0; int longestPath2 = 0; // Initialize total to 0
        visited[parent] = true;
        for (int neighbour : adj[parent]) {
            if (!visited[neighbour]) {
                int count = dfs(adj, neighbour, visited, s);
                
                if (s.charAt(parent) != s.charAt(neighbour)) {
                   if(longestPath1 < count) {
                       longestPath2 = longestPath1;
                       longestPath1 = count;
                   }else if(longestPath2 < count) {
                       longestPath2 = count;
                   }
                }
            }
        }
        diameter = Math.max(diameter, longestPath1 + longestPath2 + 1); // Update diameter
        return longestPath1 + 1;
    }
}
