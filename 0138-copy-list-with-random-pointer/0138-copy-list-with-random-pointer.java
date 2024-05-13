/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
public Node copyRandomList(Node head) {

    // HashMap which holds old nodes as keys and new nodes as its values. 
    HashMap<Node, Node> map = new HashMap<Node, Node>();
    
    //copy list nodes into hash table
    Node p = head;
    while(p != null){
        map.put(p, new Node(p.val));
        p = p.next;
    }
    
    //deep copy using hash table
    Node q = head;
    while(q != null){
        map.get(q).next = map.get(q.next);
        map.get(q).random = map.get(q.random);
        q = q.next;
    }
    
    //return new head
    return map.get(head);
}
}