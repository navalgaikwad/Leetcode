class Solution {
public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
for (int i = 0; i < n; i++) {
adj.add(new ArrayList<>());
}
for (int[] edge : edges) {
adj.get(edge[0]).add(edge[1]);
adj.get(edge[1]).add(edge[0]);
}
​
int[] ans = new int[1];
dfs(0, -1, ans, adj, values, k); // 0=node, -1=parent
return ans[0];
}
​
long dfs(int node, int parent, int[] ans, ArrayList<ArrayList<Integer>> adj, int[] values, int k) {
long sum = values[node];
​
for (Integer neighbour : adj.get(node)) {
if (neighbour != parent) {
sum += dfs(neighbour, node, ans, adj, values, k);
}
}
if (sum % k == 0) {
ans[0]++; // Update ans using the array
return 0;
}
return sum;
}
}