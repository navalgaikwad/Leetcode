class Solution {
    //same as diameter formate
    long daimeter =0;
    public long minimumFuelCost(int[][] roads, int seats) {
        ArrayList<Integer>[] adj=new ArrayList[roads.length+1];
        for(int i=0; i<=roads.length; i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] road: roads){
            adj[road[0]].add(road[1]);
            adj[road[1]].add(road[0]);
        }
        dfs(adj, 0, -1, seats);
        return daimeter;
    }
    int dfs(ArrayList<Integer>[] adj, int current, int parent, int seats) {
        int total = 1;
        for(int neighbour : adj[current]) {
            if(neighbour != parent) {
                total +=dfs(adj, neighbour, current, seats);
            }
        }
        if(current != 0) {
          daimeter += Math.ceil((double)total/(double)seats);   
        }
        return total;
    }
}