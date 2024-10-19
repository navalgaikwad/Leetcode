/*
// Definition for a Node.
class Node {
int val;
Node next;
Node random;
​
public Node(int val) {
this.val = val;
this.next = null;
this.random = null;
}
}
*/
​
class Solution {
public Node copyRandomList(Node head) {
Map<Node, Node> map = new HashMap<>();
Node p = head;
while(p!=null) {
map.put(p, new Node(p.val));
p = p.next;
}
Node q = head;
while(q!=null) {
map.get(q).next = map.get(q.next);
map.get(q).random = map.get(q.random);
q = q.next;
}
return map.get(head);
}
}