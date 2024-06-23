class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        ArrayList<int[]> adj[] = new ArrayList[n];
        int[] result=new int[n];
        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
            result[i] = -1;
        }
        for(int[] red : redEdges) {
            adj[red[0]].add(new int[]{red[1], 1});
        }
        for(int[] blue : blueEdges) {
            adj[blue[0]].add(new int[]{blue[1], 0});
        }
        
        boolean[][] visited = new boolean[n][2];
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{0, 0, -1});//src, dist, color
        result[0] = 0;
        while(!q.isEmpty()) {
            int[] current = q.remove();
            int src = current[0];
            int dist = current[1];
            int color = current[2];
            for(int[] neighbour: adj[src]) {
                int dst = neighbour[0];
                int neigbhourColor = neighbour[1];
                if(!visited[dst][neigbhourColor] && color!=neigbhourColor) {
                     if(result[dst] == -1) {
                         result[dst] = 1 + dist;
                     }
                    q.add(new int[]{dst, 1 + dist, neigbhourColor});
                    visited[dst][neigbhourColor] = true;
                }
               
            }
        }
        return result;
    }
}
//dist
//node
//color
//red =0;
//blue 1