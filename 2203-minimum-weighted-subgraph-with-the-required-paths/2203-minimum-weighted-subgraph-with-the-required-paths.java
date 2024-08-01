class Pair{
    int vertex;
    long weight;
    public Pair(int vertex, long weight){
        this.vertex= vertex;
        this.weight= weight;
    }
}
class Solution {
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        ArrayList<ArrayList<Pair>> adj= new ArrayList<>();
        ArrayList<ArrayList<Pair>> revAdj= new ArrayList<>();

        for(int i=0;i<n; i++){
            adj.add(new ArrayList<>());
            revAdj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
            revAdj.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }

        long[] scr1ToAll= shortestPath(adj, src1, new long[n]);
        long[] scr2ToAll= shortestPath(adj, src2, new long[n]);
        long[] destToAll= shortestPath(revAdj, dest, new long[n]);

        long min=Long.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(scr1ToAll[i]==Long.MAX_VALUE|| scr2ToAll[i]==Long.MAX_VALUE || destToAll[i]==Long.MAX_VALUE) continue;
            min= Math.min(min, scr1ToAll[i]+scr2ToAll[i]+destToAll[i]);
        }
        return min==Long.MAX_VALUE?-1:min;
    }

    public long[] shortestPath(ArrayList<ArrayList<Pair>> adj, int src, long[] arr){
        Arrays.fill(arr, Long.MAX_VALUE);
        arr[src]=0;
        PriorityQueue<Pair> queue= new PriorityQueue<>((a,b)-> Long.compare(a.weight,b.weight));
        queue.add(new Pair(src,0));
        while(!queue.isEmpty()){
            Pair node= queue.remove();
            int vertex= node.vertex;
            long weight= node.weight;

            if (weight > arr[vertex]) {
                continue;
            }

            for(Pair edge: adj.get(vertex)){
                if(weight+edge.weight<arr[edge.vertex]){
                    arr[edge.vertex]= weight+edge.weight;
                    queue.add(new Pair(edge.vertex, weight+edge.weight));
                }
            }
        }
        return arr;
    }
}