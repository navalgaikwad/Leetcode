class LRUCache {
    class Node {
        int key;
        int value;
        Node next;
        Node prev;
        Node(int _key, int _value) {
            this.key = _key;
            this.value = _value;
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
        if(!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.value;
    }
    
    void insert(Node node) {
        map.put(node.key, node);
        Node nextNode = head.next; 
        head.next = node;
        node.prev = head;
        node.next = nextNode;
        nextNode.prev = node;
        
    }
    
    void remove(Node noder) {
        Node node = map.remove(noder.key);
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
        }
        if(map.size()==capacity) {
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */