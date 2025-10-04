class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for(int i = 0; i<= n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for(int[] dislike : dislikes) {
            adj[dislike[0]].add(dislike[1]);
            adj[dislike[1]].add(dislike[0]);
        }
        int[] color = new int[n+1];
        Arrays.fill(color, -1);
        for(int i=0; i<n; i++) {
            if(color[i] == -1 && !bfs(i, color, adj)) {
                return false;
            }
        }
        
        return true;
    }

    boolean bfs(int src, int[] color, ArrayList<Integer>[] adj) {
        color[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()) {
            int current = q.remove();
            for(Integer neighbours: adj[current]) {
                if(color[current] == color[neighbours]) {
                    return false;
                }else if(color[neighbours] == -1) {
                    color[neighbours] = 1 - color[current];
                    q.add(neighbours);
                }
            }
        }
        return true;

    }
}