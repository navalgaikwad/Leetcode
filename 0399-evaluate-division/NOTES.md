} else {
double value = dfs(adj, node1, node2, new HashSet<>());
result[i] =value;
}
}
return result;
}
double dfs(Map<String, ArrayList<Pair>> adj, String src, String dest, HashSet<String> visited) {
visited.add(src);
if(src.equals(dest)) {
return 1.0;
}
double total = -1;
for(Pair  neighbour:adj.get(src)) {
if(!visited.contains(neighbour.c)) {
double value = dfs(adj, neighbour.c, dest, visited);
if(value != -1) {
total = neighbour.val * value;
}
}
}
return total;
}
}