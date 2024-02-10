class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<int[]> adj[] = new ArrayList[n];
        int dist[] =new int[n];
        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
             dist[i]=Integer.MAX_VALUE;
        }
        for(int[] flight: flights) {
            adj[flight[0]].add(new int[]{flight[1], flight[2]});
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0 , 0});
        dist[src] = 0;
        boolean[] visited = new boolean[n];
        visited[0] = true;
        //int minCost =Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            
                int[] current = q.remove();
                int sc = current[0];
                int cost = current[1];
                int stops = current[2];
                if(stops>k){
                    continue;
                }
                for(int[] neighbour : adj[sc]) {
                    int dest = neighbour[0];
                    int cst = neighbour[1];
                    if(cost+cst < dist[dest]) {
                        dist[dest]=cst+cost;
                        q.add(new int[]{dest, dist[dest], stops+1});
                    }
                }
        }
         if(dist[dst]==Integer.MAX_VALUE){
            return -1;
        }
        return dist[dst];
    }
}