class Solution {
      class Pair{
        int dest;
        int weight;
        Pair(int weight, int dest){
            this.dest =dest;
            this.weight = weight;
        }

        public int getDest() {
            return dest;
        }

        public int getWeight() {
            return weight;
        }
    }
    Map<Integer, List<Pair>> adj = new HashMap<>();
    public int networkDelayTime(int[][] times, int n, int k) {
        for(int[] time: times){
            int source = time[0];
            int dest = time[1];
            int timeT =time[2];

            adj.putIfAbsent(source, new ArrayList<>());
            adj.get(source).add(new Pair(timeT, dest));
        }
        int[] signalReceivedAt = new int[n + 1];
        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);
        dijkstra(signalReceivedAt, k, n);

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, signalReceivedAt[i]);
        }

        // INT_MAX signifies atleat one node is unreachable
        return answer == Integer.MAX_VALUE ? -1 : answer;

    }

    private void dijkstra(int[] signalReceivedAt, int source, int n) {

        PriorityQueue<Pair>pq=new PriorityQueue<Pair>(Comparator.comparing(Pair::getWeight));

        pq.add(new Pair(0, source));
        signalReceivedAt[source]=0;

        while(!pq.isEmpty()){
            Pair pair=pq.remove();
            int cuurNode=pair.getDest();
            int currTime=pair.weight;

         
            //if not present in adj list skip it
            if(!adj.containsKey(cuurNode)){
                continue;
            }

            for(Pair edge : adj.get(cuurNode)){
                int time = edge.weight;
                int neighborNode = edge.getDest();

                if(currTime + time<signalReceivedAt[neighborNode] ){
                    signalReceivedAt[neighborNode] = currTime + time;
                    pq.add(new Pair(signalReceivedAt[neighborNode], neighborNode));
                }
            }
        }
    }
}