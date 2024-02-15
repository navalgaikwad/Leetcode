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
    int _capacity = 0;
    public LRUCache(int capacity) {
        _capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            add(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
           Node node = map.get(key);
           remove(node); 
        }
        if(map.size() == _capacity) {
            remove(tail.prev);
        }
        add(new Node(key, value));
    }
    
    void add(Node node) {
        map.put(node.key, node);
        Node next = head.next;
        Node prev = head;
        
        head.next = node;
        node.prev = prev;
        node.next = next;
        next.prev = node;
    }
    
    void remove(Node node) {
        map.remove(node.key);
        Node nextNode = node.next;
        Node prevNode = node.prev;
        
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */