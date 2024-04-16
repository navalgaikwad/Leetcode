class Solution {
    int diameter = 0;
    public int longestPath(int[] parent, String s) {
        int len = parent.length;
        ArrayList<Integer> adj[] = new ArrayList[len];
        for(int i=0; i < len; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 0;i <len; i++) {
            if(parent[i] != - 1) {
                adj[parent[i]].add(i);
            }
            
        }
        boolean[] visited = new boolean[len];
        helper(adj, 0, visited, s);
        return diameter;
    }
    
    int helper(ArrayList<Integer> adj[], int parent, boolean[] visited, String s) {
        visited[parent] = true;
        int left =0; int right = 0;
        for(Integer neighbour : adj[parent]) {
            if(!visited[neighbour]) {
                int count = helper(adj, neighbour, visited, s);
                if(s.charAt(neighbour)!= s.charAt(parent)) {
                    
                    if(left < count) {
                        right = left;
                        left = count;
                    }else if(right < count){
                        right = count;
                    }
                }
            }
        }
        diameter = Math.max(diameter, 1 + left + right);
        return 1 + left;
    }
    
    
}