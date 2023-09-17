class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
       Map<String, List<String>> graph = new HashMap<>();

        // Step 1: Construct the graph
        for (List<String> ticket : tickets) {
            String departure = ticket.get(0);
            String arrival = ticket.get(1);

            graph.putIfAbsent(departure, new ArrayList<>());
            graph.get(departure).add(arrival);
        }

        // Step 3: Sort the lists of destinations
        for (List<String> destinations : graph.values()) {
            Collections.sort(destinations);
        }

        Stack<String> stack = new Stack<>();
        List<String> circuit = new ArrayList<>();

        // Step 6: Push the starting airport to the stack
        stack.push("JFK");

        // Step 7: Perform DFS using stack
        while (!stack.isEmpty()) {
            String current = stack.peek();

            // Step 7b: If current airport has no outgoing edges, add it to the circuit
            if (!graph.containsKey(current) || graph.get(current).isEmpty()) {
                circuit.add(stack.pop());
            } else {
                // Step 7c: Push the next unvisited destination to the stack and remove the edge from the graph
                stack.push(graph.get(current).remove(0));
            }
        }

        // Step 8: Reverse the circuit to get the correct order
        Collections.reverse(circuit);

        return circuit;
      
    }
}