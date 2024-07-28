class Solution {
    int result = 0;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        ArrayList<Integer> adj[] = new ArrayList[n];
        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        dfs(adj, visited, 0, values, k);
        return result;
    }
    long dfs(ArrayList<Integer> adj[], boolean[] visited, int start, int[] values, int k) {
        visited[start] = true;
        long sum = values[start];
        for(Integer neighbour : adj[start]) {
            if(!visited[neighbour]) {
                sum += dfs(adj, visited, neighbour, values, k);
            }
        }
        if(sum%k == 0) {
            result++;
            return 0;
        }
        return sum;
    }
}