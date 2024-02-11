class Solution {
    class Pair {
        String c;
        double val;
        Pair(String c, double val) {
            this.c = c;
            this.val = val;
        }
    //     @Override
    // public String toString() {
    //     return "(" + c + ", " + val + ")";
    // }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, ArrayList<Pair>> adj = new HashMap<>();
        int j =0;
        for(List<String>  equation: equations) {
            adj.putIfAbsent(equation.get(0), new ArrayList<>());
            adj.putIfAbsent(equation.get(1), new ArrayList<>());
            adj.get(equation.get(0)).add(new Pair(equation.get(1), values[j]));
            adj.get(equation.get(1)).add(new Pair(equation.get(0), 1/values[j]));
            j++;
        }
        //System.out.print(adj);
         double[] result = new double[queries.size()];
        for(int i=0; i<queries.size(); i++){
          String node1 =  queries.get(i).get(0);
          String node2 =  queries.get(i).get(1);
            if(!adj.containsKey(node1) || !adj.containsKey(node2)){
                result[i] =-1.0;
            }else{
                double value = dfs(adj, node1, node2, new HashSet<>());
                result[i] =value;
            }
            
        }
        return result;
       // return new double[]{};
    }
    
    double dfs(Map<String, ArrayList<Pair>> adj, String src, String dst, HashSet<String> visited) {
        visited.add(src);
        if(src.equals(dst)) {
            return 1.0;
        }
        double total = -1;
        for(Pair pair: adj.get(src)) {
            String neighbour = pair.c;
            double value = pair.val;
            if(!visited.contains(neighbour)) {
                double sum = dfs(adj, neighbour, dst, visited);
                if(sum != -1) {
                   sum = sum*value; 
                   total = sum;
                   //return sum;
                }
                
            }
        }
        return total;
    }
}