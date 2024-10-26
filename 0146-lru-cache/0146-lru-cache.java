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
    int capacity =0;
    public LRUCache(int capacity) {
        this.head.next = tail;
        this.tail.prev = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        addFront(node);
        return node.value;
    }
    
    public void put(int key, int value) {
         if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
        }
        if(capacity == map.size()) {
             remove(tail.prev); 
        }
       
         addFront(new Node(key, value));
    }
    
    void addFront(Node node) {
        map.put(node.key, node);
        Node next = head.next;
        Node prev = head;
        node.next = next;
        next.prev = node;
        head.next = node;
        node.prev = prev;
    }
    void remove(Node node) {
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