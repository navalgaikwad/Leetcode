class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        ArrayList[] adj = new ArrayList[n];
        for(int i=0; i<n; i++){
       adj[i]=new ArrayList<>();     
       }
        for(int[] redEdge: redEdges){
            adj[redEdge[0]].add(new int[]{redEdge[1], 0});
        }
        
         for(int[] blueEdge: blueEdges){
            adj[blueEdge[0]].add(new int[]{blueEdge[1], 1});
        }
        
        boolean[][] visited = new boolean[n][2];
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, -1});//current, dist, color
         result[0]=0;
        while(!queue.isEmpty()){
            int[] currents = queue.remove();
            ArrayList<int[]>current= adj[currents[0]]; //get value from adj list for current node
            for(int[] neighbour: current){
                if(!visited[neighbour[0]][neighbour[1]] && neighbour[1]!= currents[2]){
                    if(result[neighbour[0]] ==-1){
                        result[neighbour[0]] = 1+  currents[1];
                        
                    }
                   visited[neighbour[0]][neighbour[1]]=true;
                   queue.add(new int[]{neighbour[0], currents[1] + 1, neighbour[1]});
                }
            }
        }
        return result;
    }
}

//neighbour[1] = color