class Solution {
public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
boolean[] visited =new boolean[n];
ArrayList<Integer>adj[] = new ArrayList[n];
for(int i=0; i<n; i++){
adj[i]=new ArrayList<>();
}
for(int[] edge: edges){
adj[edge[0]].add(edge[1]);
adj[edge[1]].add(edge[0]);
}
return dfs(adj, 0, visited, hasApple);
}
int dfs(ArrayList<Integer>adj[], int current, boolean[] visited, List<Boolean> hasApple){
int time=0;
visited[current]=true;
for(Integer neighbour: adj[current]){
if(visited[neighbour]){
continue;
}
time =time+dfs(adj, neighbour, visited, hasApple);
}
if(current!=0 && (hasApple.get(current)|| time>0)){
time =time+2;
}
return time;
}
}