class Solution {
public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
ArrayList<int[]> adj[] = new ArrayList[n];
int[] dest = new int[n];
for(int i=0; i<n; i++) {
adj[i] = new ArrayList<>();
dest[i] = Integer.MAX_VALUE;
}
for(int[] flight :flights) {
adj[flight[0]].add(new int[]{flight[1], flight[2]});
}
boolean[] visited = new boolean[n];
Queue<int[]> q = new LinkedList<>();
q.add(new int[]{src, 0, 0});
while(!q.isEmpty()) {
int[] current = q.remove();
int sc = current[0];
int cost = current[1];
int stop = current[2];
for(int[] neighbours: adj[sc]) {
int neighbour =  neighbours[0];
int cst = neighbours[1];
if(cost+cst <dest[neighbour]  && stop<=k) {
dest[neighbour] = cost + cst;
// visited[neighbour] = true;
q.add(new int[]{neighbour, cost+cst, stop + 1});
}
}
}
if(dest[dst] == Integer.MAX_VALUE) {
return -1;
}
return dest[dst];
}
}