class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<Integer> adj[] = new ArrayList[n];
        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        return helper(adj, 0, new HashSet<>(), hasApple);
    }
    
    int helper(ArrayList<Integer> adj[], int parent, HashSet<Integer> visited,List<Boolean> hasApple) {
        int total = 0;
        visited.add(parent);
        for(Integer neighbour : adj[parent]) {
            if(!visited.contains(neighbour)) {
                int count = helper(adj, neighbour, visited, hasApple);
                total = total + count;
               
            }
        }
         if(parent != 0 && (hasApple.get(parent) || total>0)) {
            total = total +  2;
        }
        return total;
    }
}