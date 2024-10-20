if(!dfs(adj, stack, i, visited)){
return new int[]{};
}
}
int i = 0;
while (!stack.isEmpty()) {
ans[i++] = stack.peek();
stack.pop();
}
return ans;
}
boolean dfs(ArrayList<Integer>[]adj,Stack<Integer> stack, int node, int[] visited){
if(visited[node]==1) {
return false;
}
if(visited[node]==2){
return true;
}
visited[node]=1;
​
for(int neighbour: adj[node]){
if (!dfs(adj, stack, neighbour, visited)){
return false;
}
}
stack.push(node);
visited[node] = 2;
​
return true;
​
}
}