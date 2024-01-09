class LRUCache {
class Node {
int key;
int value;
Node next;
Node prev;
Node(int key, int value) {
this.key = key;
this.value = value;
}
}
Node head = new Node(0, 0);
Node tail = new Node(0, 0);
Map<Integer, Node> map = new HashMap<>();
int capacity;
public LRUCache(int _capacity) {
capacity =_capacity;
head.next = tail;
tail.prev = head;
}
public int get(int key) {
if(map.containsKey(key)){
Node node = map.get(key);
remove(node);
insert(node);
return node.value;
}
return -1;
}
public void put(int key, int value) {
if(map.containsKey(key)) { // 1. check already there if there remove it because newly added  should be on the top
Node node = map.get(key);
remove(node);
}
if(map.size() == capacity){ // 2. if it is full remove from end because it is least used old data