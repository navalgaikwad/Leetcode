class Solution {
    int[] ans;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        ArrayList<Integer> adj[] = new ArrayList[n];
        ans = new int[n];
        for(int i=0; i<n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] edge: edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[n];
         dfs(adj, 0, visited, labels);
        return ans;
    }
    int[] dfs(ArrayList<Integer> adj[], int parent, boolean[] visited, String label) {
        int[] countFrequnecy = new int[26];
        visited[parent] = true;
        for(Integer neigbhour : adj[parent]) {
            if(!visited[neigbhour]) {
               int[] contains = dfs(adj, neigbhour, visited, label); 
               for(int i =0; i<26; i++) {
                   countFrequnecy[i] = countFrequnecy[i] + contains[i];
               }
               
            }
        }
        countFrequnecy[label.charAt(parent) - 'a']++;
        ans[parent] = countFrequnecy[label.charAt(parent) - 'a'];
        return countFrequnecy;
    }
    

}