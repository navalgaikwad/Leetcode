class Solution {
public int findCircleNum(int[][] isConnected) {
int n=isConnected.length;
ArrayList<Integer> [] adj =new ArrayList[n];
for(int i=0;i<n;i++){
adj[i]=new ArrayList<>();
}
for(int i=0;i<n;i++){
for(int j=0;j<n;j++){
if(isConnected[i][j] == 1){
adj[i].add(j);
adj[j].add(i);
}
}
}
int count = 0;
boolean[] visited = new boolean[n+1];
for(int i=0; i<n; i++) {
if(!visited[i]) {
helper(adj, i, visited);
count++;
}
}
return count;
}
void helper(ArrayList<Integer> [] adj, int parent, boolean[] visited) {
visited[parent] = true;
for(Integer neighbour: adj[parent]) {
if(!visited[neighbour]) {
helper(adj, neighbour, visited);
}
}
}
}