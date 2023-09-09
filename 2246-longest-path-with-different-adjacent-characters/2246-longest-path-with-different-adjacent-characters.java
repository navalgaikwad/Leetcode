class Solution {
    int max=1;
    public int longestPath(int[] parent, String s) {
        int n=parent.length;
        if(n==1){
            return 1;
        }
        ArrayList<Integer>adj[] =new ArrayList[n];
        for(int i=0; i<n; i++){
            adj[i]=new ArrayList<>();
        }
        
        for(int i=1;i<n;i++){
            adj[parent[i]].add(i);
        }
        int[] dist=new int[n];
        dfs(adj, 0, -1, dist, s);
        return max;
        
    }
    
    void dfs(ArrayList<Integer>adj[], int current, int parent, int[] dist, String s){
        dist[current]=1;
        for(Integer neighour :adj[current]){
            if(neighour == parent) continue;
            dfs(adj, neighour, current, dist, s);
            if(s.charAt(current)!=s.charAt(neighour)){
                max=Math.max(max, dist[current]+dist[neighour]);
                dist[current]=Math.max(dist[current], dist[neighour]+1);
                 
            }
        }
    }
}