class Solution {
    class Node{
        String node;
        double weight;
        Node(String node, double weight){
        this.node = node;
        this.weight = weight;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
       Map<String, List<Node>> adj = new HashMap<>();
        int j =0;
        for(List<String> equation: equations){
            if(!adj.containsKey(equation.get(0))){
              adj.put(equation.get(0), new ArrayList<Node>());  
            }
            adj.get(equation.get(0)).add(new Node(equation.get(1), values[j]));
            
            if(!adj.containsKey(equation.get(1))){
              adj.put(equation.get(1), new ArrayList<>());  
            }
            adj.get(equation.get(1)).add(new Node(equation.get(0), 1/values[j]));
            j++;
        }
        System.out.print(adj);
        //HashSet<String> visited = new HashSet<>();
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
        //return new double[]{};
    }
    
    double dfs(Map<String, List<Node>> adj, String src, String dst, HashSet<String> visited){
        visited.add(src);
        if(src.equals(dst)){
            return 1.0;
        }
       // double total = 0.0;
        for(Node neighbour: adj.get(src)){
             String neigb = neighbour.node;
             double weight = neighbour.weight;
            if(!visited.contains(neigb)){
             double  total = dfs(adj, neigb, dst, visited);
             if(total!=-1){
               total = total * weight; 
              return total;
             }
               
             
            }
        }
        return -1;
    }
}