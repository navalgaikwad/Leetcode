class LRUCache {
    class Node {
        int val;
        int key;
        Node next;
        Node prev;
        Node(int _key, int _val) {
            this.key = _key;
            this.val = _val;
        }
    }
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    int _capacity;
    Map<Integer, Node> map = new HashMap<>();
    public LRUCache(int capacity) {
        _capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        Node vaolue = map.get(key);
        remove(vaolue);
        add(vaolue);
        return vaolue.val;
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
    void add(Node node) {
        map.put(node.key, node);
        Node next= head.next;
        //Node prev = head;
        
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }
    
    void remove(Node key) {
        Node node = map.remove(key.key);
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