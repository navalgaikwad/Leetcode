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
remove(tail.prev);
}
insert(new Node(key, value)); //3. add the data
}
private void insert(Node node){ // add at first
map.put(node.key, node);
Node nextNode = head.next; //3
Node preNode = head;
head.next  = node;
node.prev = head;
node.next = nextNode;
//node.prev = preNode;
nextNode.prev = node;
}
private void remove(Node node){ // remove from any point
map.remove(node.key);
node.prev.next = node.next;
node.next.prev = node.prev;
}
}
​
/**
* Your LRUCache object will be instantiated and called as such:
* LRUCache obj = new LRUCache(capacity);
* int param_1 = obj.get(key);
* obj.put(key,value);
*/