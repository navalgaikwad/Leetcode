class Solution {
    class Pair {
        int dest;
        int weight;
        Pair(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }
    Map<Integer, List<Pair>> adj = new HashMap<>();
    public int networkDelayTime(int[][] times, int n, int k) {
        for(int[] time: times) {
            int src = time[0];
            int dest = time[1];
            int weight = time[2];
            adj.putIfAbsent(src, new ArrayList<>());
            adj.get(src).add(new Pair(dest, weight));
        }
        int[] signaltravel = new int[n+1];
        // int[] signalReceivedAt = new int[n + 1];
        Arrays.fill(signaltravel, Integer.MAX_VALUE);
        bfs(adj, k, signaltravel);

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, signaltravel[i]);
        }

        // INT_MAX signifies atleat one node is unreachable
        return answer == Integer.MAX_VALUE ? -1 : answer;
        
    }
    
    void bfs(Map<Integer, List<Pair>> adj, int k, int[] signaltravel) {
        //PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing(Pair::Pair.weight));
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.weight));
        pq.add(new Pair(k, 0));
        signaltravel[k] = 0;
        while(!pq.isEmpty()) {
            Pair p = pq.remove();
            int src = p.dest;
            int cost = p.weight;
            
            if(!adj.containsKey(src)) {
                continue;
            }
            for(Pair neigbhour : adj.get(src)) {
                int dest = neigbhour.dest;
                int weight = neigbhour.weight;
                if(cost + weight < signaltravel[dest]) {
                    signaltravel[dest] = cost + weight;
                    pq.add(new Pair( dest, cost + weight));
                }
            }
        }
    }
}