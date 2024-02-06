import java.util.ArrayList;

class Solution {
    public int minScore(int n, int[][] roads) {
        ArrayList<int[]> adj[] = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] road : roads) {
            adj[road[0]].add(new int[]{road[1], road[2]});
            adj[road[1]].add(new int[]{road[0], road[2]});
        }
        
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        return dfs(adj, 1, visited);
    }
    
//     staticinthelper(Noderoot){
// if(root==null)returnInteger.MIN_VALUE;;
// inttotal=Integer.MIN_VALUE;
// for(Nodechild:root.children){
// inttotalMax=helper(child);
// total=Math.max(total,totalMax+root.data);
// }
// returnMath.max(total,root.data);
// }

    int dfs(ArrayList<int[]> adj[], int parent, boolean[] visited) {
        int total = Integer.MAX_VALUE;

        for(int[] neighbours : adj[parent]) {
            int neighbour = neighbours[0];
            int cost = neighbours[1];
             total = Math.min(total, cost);
            if (!visited[neighbour]) {
                visited[neighbour] = true; // Mark the current node as visited before the recursive call
                int min = dfs(adj, neighbour, visited);
                total = Math.min(total, min); // Update total only with the current cost, not with min
            }
        }
       
        return total;
    }
}
