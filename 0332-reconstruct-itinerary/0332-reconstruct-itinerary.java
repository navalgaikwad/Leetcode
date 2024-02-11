class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> adj = new HashMap<>();
        for(List<String> neighbours : tickets) {
            String src = neighbours.get(0);
            String dst = neighbours.get(1);
            adj.putIfAbsent(src, new ArrayList<>());
            adj.get(src).add(dst);
        }
        
        for(List<String> destinations : adj.values()) {
            Collections.sort(destinations);
        }
        
        System.out.print(adj);
        Stack<String> st = new Stack<>();
        List<String> result = new ArrayList<>();
        st.push("JFK");
        while(!st.isEmpty()) {
            String current = st.peek();
            if(!adj.containsKey(current) || adj.get(current).isEmpty()) {
                result.add(st.pop());
            } else {
                st.push(adj.get(current).remove(0));
            }
        }
         // Step 8: Reverse the circuit to get the correct order
        Collections.reverse(result);
        return result;
    }
}