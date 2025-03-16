class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        int destination = n-1;
        int source = 0;
        Integer[] timeHold = new Integer[n];
        Arrays.fill(timeHold, Integer.MAX_VALUE);

        Map<Integer,List<int[]>> graph = new HashMap();
        for(int[] edge : edges){
            int src = edge[0];
            int dst = edge[1];
            int time = edge[2];
            graph.putIfAbsent(src,new ArrayList());
            graph.putIfAbsent(dst,new ArrayList());
            graph.get(src).add(new int[]{dst,time});
            graph.get(dst).add(new int[]{src,time});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>( (a, b) -> a[1] - b[1] ); //a[0] = city, a[1] = cost, a[2] = time
        pq.offer(new int[]{source, passingFees[source], 0});
        timeHold[0] = 0;
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int src = node[0];
            int fee = node[1];
            int time = node[2];

            if(src == destination) // check whether destination reached ?
                return fee;
            
            for(int[] nei : graph.get(src)){
                
                int neiNode = nei[0];
                int neiTime = nei[1];
                                              
                if(time + neiTime > maxTime) // we cannot exceed maxTime, return .. 
                    continue;
                
                if(time + neiTime < timeHold[neiNode]){
                    timeHold[neiNode] = time + neiTime; //we found lesser time update time Array and add this node to pq..
                    pq.add(new int[]{neiNode, fee + passingFees[neiNode], timeHold[neiNode]});
                }
            }
        }
        return -1;
    }
}