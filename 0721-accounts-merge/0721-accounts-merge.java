class Solution {
     public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> graph = new HashMap<>();  //<email node, neighbor nodes>
        Map<String, String> owner = new HashMap<>();        //<email, username>
        
         // Build the graph;
        for (List<String> account : accounts) {
            String userName = account.get(0);
            Set<String> neighbors = new HashSet<>(account);
            neighbors.remove(userName);
            
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!graph.containsKey(email)) {
                    graph.put(email, new HashSet<>());
                }
                graph.get(email).addAll(neighbors);
                owner.put(email, userName);
            }
        }
        
        Set<String> visited = new HashSet<>();
        List<List<String>> results = new ArrayList<>();
        // DFS search the graph;
         for (String email : owner.keySet()) {
             if (!visited.contains(email)) {
                List<String> result = new ArrayList<>();
                dfs(graph, email, visited, result);
                Collections.sort(result);
                result.add(0, owner.get(email));
                results.add(result);
             }
         }
        
        
        return results;
    }
    
    public void dfs(Map<String, Set<String>> graph, String email, Set<String> visited, List<String> list) {
        list.add(email);
        visited.add(email);
        for (String neighbor: graph.get(email)) {
            if (!visited.contains(neighbor)) {
                dfs(graph, neighbor, visited, list);    
            }
        }
    }
}  