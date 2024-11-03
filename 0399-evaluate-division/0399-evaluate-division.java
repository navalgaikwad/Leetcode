class Solution {
    class Pair {
        String st;
        double weight;
        Pair(String st, double weight) {
            this.st = st;
            this.weight = weight;
        }
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair>> adj = new HashMap<>();
        int index =0;
        for(List<String> equation :equations) {
            adj.putIfAbsent(equation.get(0), new ArrayList<>());
            adj.putIfAbsent(equation.get(1), new ArrayList<>());
            adj.get(equation.get(0)).add(new Pair(equation.get(1), values[index]));
            adj.get(equation.get(1)).add(new Pair(equation.get(0), 1/values[index]));
            index++;
        }
        index = 0;
        double[] result = new double[queries.size()];
        for(List<String> querie : queries) {
            if(!adj.containsKey(querie.get(0)) || !adj.containsKey(querie.get(1))) {
                result[index] = -1;
            }else {
                double value = dfs(adj, querie.get(0), querie.get(1), new HashSet<>());
                result[index] = value;
            }
            index++;
        }
        return result;
    }
    
    
    double dfs(Map<String, List<Pair>> adj, String start, String end, Set<String> visited) {
        if(start.equals(end)) {
            return 1.0;
        }
        double total = -1;
        visited.add(start);
        for(Pair neighbour: adj.get(start)) {
            if(!visited.contains(neighbour.st)) {
                double value = dfs(adj, neighbour.st,  end, visited);
                if(value != -1) {
                    total = value * neighbour.weight;
                } 
            }
        }
        return total;
    }
}