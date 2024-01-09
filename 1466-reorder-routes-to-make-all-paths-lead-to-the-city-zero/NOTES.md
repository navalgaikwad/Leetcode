class Solution {
public int minReorder(int n, int[][] connections) {
ArrayList<int[]> adj[] = new ArrayList[n];
for (int i = 0; i < n; i++) {
adj[i] = new ArrayList<>();
}
​
for (int[] con : connections) {
adj[con[0]].add(new int[]{con[1], 0});
adj[con[1]].add(new int[]{con[0], 1});
}
​
return dfs(adj, 0, new HashSet<>());
}
​
int dfs(ArrayList<int[]> adj[], int parent, HashSet<Integer> visited) {
int solution = 0;
visited.add(parent);
for (int[] neighbour : adj[parent]) {
int neighbourNode = neighbour[0];
int count = neighbour[1];
if (!visited.contains(neighbourNode)) {
solution = solution + count + dfs(adj, neighbourNode, visited);
}
}
return solution;
}
}
​