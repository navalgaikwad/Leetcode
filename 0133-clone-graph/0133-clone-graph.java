/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
    if(node == null ) return null;
     Map<Node, Node> map = new HashMap<>();
     // need to return references so we need to use Map<Node, Node> map 
     //create a node of node rather list of node
     Queue<Node> queue = new LinkedList<>();
        
     queue.add(node);
     //put first node along with new node
     map.put(node, new Node(node.val, new ArrayList<>()));
     while(!queue.isEmpty()){
        Node current = queue.remove();//1
      
         //visit neighbour
        for(Node neighbor: current.neighbors){
            if(!map.containsKey(neighbor)){
                queue.add(neighbor);
                
                map.put(neighbor, new Node(neighbor.val, new ArrayList<>() ));
            }
        // add neighbour to current
         map.get(current).neighbors.add(map.get(neighbor));  
        }
     }
     return map.get(node);
    }
}