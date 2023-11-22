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
        if(node == null){
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        map.put(node, new Node(node.val, new ArrayList<>()));
        while(!queue.isEmpty()){
            Node current = queue.remove();
            for(Node neighbour : current.neighbors){
              if(!map.containsKey(neighbour)){
                queue.add(neighbour);
                map.put(neighbour, new Node(neighbour.val, new ArrayList<>()));
            }
            map.get(current).neighbors.add(map.get(neighbour));
          }
        }
        return map.get(node);
    }
}