class Solution {
    public int minScore(int n, int[][] roads) {
        ArrayList<int[]> adj[] = new ArrayList[n+1];
        for(int i=1; i <=n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] road : roads) {
            adj[road[0]].add(new int[]{road[1], road[2]});
            adj[road[1]].add(new int[]{road[0], road[2]});
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        
        int min = Integer.MAX_VALUE;
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        while(!q.isEmpty()) {
            int current = q.remove();
            for(int[] neighbour : adj[current]) {
                int dst = neighbour[0];
                min = Math.min(min, neighbour[1]);
                if(!visited[dst]) {
                    visited[dst] = true;
                    q.add(dst);
                }
            }
        }    
        return min;
    }
}