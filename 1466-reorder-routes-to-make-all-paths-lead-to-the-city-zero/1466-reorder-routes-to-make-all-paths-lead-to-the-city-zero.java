class Solution {
    public int minReorder(int n, int[][] connections) {
        ArrayList<int[]> adj[] = new ArrayList[n];
        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] connection : connections) {
            adj[connection[0]].add(new int[]{connection[1], 1});
            adj[connection[1]].add(new int[]{connection[0], 0});
        }
        boolean[] visiting = new boolean[n];
        return helper(adj, 0, visiting);
    }
    int helper(ArrayList<int[]> adj[], int parent, boolean[] visiting) {
        visiting[parent] = true;
        int total = 0;
        for(int[] neighbour: adj[parent]) {
            if(!visiting[neighbour[0]]) {
                total+=neighbour[1] + helper(adj, neighbour[0], visiting);
            }
        }
        return total;
    }
}