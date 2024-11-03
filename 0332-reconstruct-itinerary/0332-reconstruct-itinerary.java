class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        // Step 1: Build the adjacency list
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dst = ticket.get(1);
            adj.putIfAbsent(src, new PriorityQueue<>());
            adj.get(src).offer(dst);
        }
        
        List<String> result = new LinkedList<>();
        
        // Step 2: Start DFS from "JFK"
        dfs("JFK", adj, result);
        
        return result;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> adj, List<String> result) {
        PriorityQueue<String> destinations = adj.get(airport);
        
        // Visit all destinations from the current airport in lexicographical order
        while (destinations != null && !destinations.isEmpty()) {
            String next = destinations.poll();
            dfs(next, adj, result);
        }
        
        // Add airport to the result after visiting all its destinations
        result.add(0, airport); // Prepend to build the path in reverse order
    }
}
