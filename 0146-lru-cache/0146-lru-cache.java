class LRUCache {
class Node {
    int key;
    int value;
    Node prev;
    Node next;
    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    int _capacity;
    Map<Integer, Node> map = new HashMap<>();
    public LRUCache(int capacity) {
        this._capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        add(node);
        return node.value;
    }
    
    void add(Node node) {
        map.put(node.key, node);
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }
    
    void remove(Node node) {
        Node root = map.remove(node.key);//vvimp rmeove key
        Node next = root.next;
        Node prev = root.prev;
        prev.next = next;
        next.prev = prev;
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
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */