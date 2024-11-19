class Solution {
    class Tuple{
        int stop;
        int src;
        int weight;
        Tuple(int stop, int src, int weight){
            this.stop = stop;
            this.src = src;
            this.weight=weight;
        }
    }
    class Pair{
        int dest;
        int cost;
        Pair(int dest, int cost){
            this.dest=dest;
            this.cost=cost;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int dist[] =new int[n];
        ArrayList<Pair>adj[] =new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
            dist[i]=Integer.MAX_VALUE;
           
        }
        for(int[] flight: flights){
            adj[flight[0]].add(new Pair(flight[1], flight[2])); 
        }
        Queue<Tuple>q=new LinkedList<>();
        q.add(new Tuple(0, src, 0));
        dist[src]=0;
        while(!q.isEmpty()){
            Tuple t = q.remove();
            int stop = t.stop;
            int sc =t.src;
            int weight =t.weight;
            for(Pair p: adj[sc]){
              int dest=  p.dest;
              int cost=  p.cost;
               
                if(weight+cost<dist[dest]&& stop<=k){
                    dist[dest]=weight+cost;
                    q.add(new Tuple(stop+1,dest, weight+cost ));
                }
            }
        }
        if(dist[dst]==Integer.MAX_VALUE){
            return -1;
        }
        return dist[dst];
    }
}