class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<Integer> adj[] = new ArrayList[n];
        for(int i=0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        return helper(adj, 0, hasApple, visited);
    }
    
    int helper(ArrayList<Integer> adj[], int parent, List<Boolean> hasApple, boolean[] visited) {
        int total = 0;
        visited[parent] = true;
        for(Integer neighbour: adj[parent]) {
            if(!visited[neighbour]) {
                int count = helper(adj, neighbour, hasApple, visited);
                total +=count;
            }
        }
        if(parent!=0 && (hasApple.get(parent) || total > 0)) {
            total+=2;
        }
        return total;
    }
}