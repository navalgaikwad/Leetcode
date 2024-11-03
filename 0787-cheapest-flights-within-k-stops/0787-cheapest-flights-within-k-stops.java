class Solution {
    class Pair {
        int dest;
        int weight;
        Pair(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Pair>adj[] = new ArrayList[n];
         int[] dest = new int[n];
        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
            dest[i] = Integer.MAX_VALUE;
        }
        for(int[] flight: flights) {
            adj[flight[0]].add(new Pair(flight[1], flight[2]));
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0, 0});
        int result = -1;
        while(!q.isEmpty()) {
            int[] current = q.remove();
            int sc = current[0];
            int dist = current[1];
            int stop = current[2];
            if(stop > k) {
                continue;
            }
            for(Pair neighbour : adj[sc]) {
                int destination = neighbour.dest;
                int weight = neighbour.weight;
                if(dist+weight < dest[destination] && stop <=k) {
                    dest[destination] = dist+weight;
                    q.add(new int[]{destination, dist+weight, stop+1});
                }
            }
        }
         if(dest[dst] == Integer.MAX_VALUE) {
            return -1;
        }
        return dest[dst];
    }
}