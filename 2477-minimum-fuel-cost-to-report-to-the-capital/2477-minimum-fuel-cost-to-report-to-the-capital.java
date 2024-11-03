class Solution {
    long result = 0;
    public long minimumFuelCost(int[][] roads, int seats) {
        int len = roads.length;
        
        ArrayList<Integer> adj[] = new ArrayList[len+1];
        
        for(int i=0; i<=len; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] road : roads) {
            adj[road[0]].add(road[1]);
            adj[road[1]].add(road[0]);
        }
        boolean[] visited = new boolean[len+1];
        helper(adj, 0, visited, seats);
        return result;
    }
    
    int helper(ArrayList<Integer> adj[], int parent, boolean[] visited, int seats) {
        visited[parent] = true;
        int total = 1;
        for(Integer neighbour : adj[parent]) {
            if(!visited[neighbour]) {
                total+=helper(adj, neighbour, visited, seats);
            }
        }
         if(parent != 0) {
            result += Math.ceil((double)total/ (double)seats); 
         }
        return total;
    }
}