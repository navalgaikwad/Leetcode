class Solution {
public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
ArrayList<int[]> adj[] = new ArrayList[n];
int[] result=new int[n];
for(int i=0; i<n; i++) {
adj[i] = new ArrayList<>();
result[i] = -1;
}
for(int[] red : redEdges) {
adj[red[0]].add(new int[]{red[1], 1});
}
for(int[] blue : blueEdges) {
adj[blue[0]].add(new int[]{blue[1], 0});
}
boolean[][] visited = new boolean[n][2];
Queue<int[]> q = new LinkedList<>();
q.add(new int[]{0, 0, -1});
result[0]=0;
while(!q.isEmpty()) {
int[] current = q.remove();
int dist = current[0];//dist
int node = current[1];//node
int col = current[2];//color
for(int[] neighbours: adj[node]) {
int next = neighbours[0];
int colr = neighbours[1];
if(!visited[next][colr] && col!=colr) {
if(result[next] == -1) {
result[next] = dist + 1;
}
visited[next][colr] = true; //mark it is visited
q.add(new int[]{1+ dist, next, colr });
}
}
}
return result;
}
}
//dist
//node
//color
//red =0;
//blue 1