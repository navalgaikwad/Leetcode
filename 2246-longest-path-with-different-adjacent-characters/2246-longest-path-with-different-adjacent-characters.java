class Solution {
    int diameter = Integer.MIN_VALUE;
    public int longestPath(int[] parent, String s) {
        int n = s.length();
        ArrayList<Integer> adj[] = new ArrayList[s.length() + 1];
        for(int i=0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for(int i=0; i<n; i++) {
            if(parent[i] != -1) {
               adj[parent[i]].add(i); 
            }
        }
        boolean[] visited = new boolean[n];
        helper(adj, 0, visited, s);
        return diameter;
    }
    
    int helper(ArrayList<Integer> adj[], int parent, boolean[] visited, String s) {
        int firstMax = 0; int secondMax = 0;
        visited[parent] = true;
        for(Integer neighbour: adj[parent]) {
            if(!visited[neighbour]) {
                int count = helper(adj, neighbour, visited, s);
                if(s.charAt(parent) != s.charAt(neighbour)) {
                    if(firstMax < count) {
                        secondMax = firstMax;
                        firstMax = count;
                    } else if(secondMax < count) {
                        secondMax = count;
                    }
                }
            }
        }
        diameter = Math.max(diameter, firstMax + secondMax + 1);
        return firstMax + 1;
    }
}