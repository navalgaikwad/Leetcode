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
    int _capacity =0;
    Map<Integer, Node> map = new HashMap<>();
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    public LRUCache(int capacity) {
        _capacity = capacity;
        head.next= tail;
        tail.next = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        add(new Node(node.key, node.value));
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
        }
        if(_capacity == map.size()) {
            remove(tail.prev);
        }
        
        add(new Node(key, value));
    }
    
    void add(Node node) {//map madhye add kar
        map.put(node.key, node);
        Node next = head.next;
        //Node prev = head;
        
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }
    
    void remove(Node node) {//map madhun remove kar
        map.remove(node.key);
        
        Node next = node.next;
        Node prev = node.prev;
        
        prev.next = next;
        next.prev = prev;
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */