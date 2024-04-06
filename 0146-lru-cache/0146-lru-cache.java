
class LRUCache {
    class Node {
        int key;
        int value;
        Node next;
        Node prev;
        Node(int _key, int _value) {
            this.key = _key;
            this.value = _value;
           // next = null;
            //prev = null;
                
        }
    }
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    Map<Integer, Node> map = new HashMap<>();
    int _capacity;
    public LRUCache(int capacity) {
        _capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
         return  -1;
        }
           Node node = map.get(key);
           remove(node);
           insert(node);
           return node.value;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
        }
        if(map.size() ==_capacity) {
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }
    
    void insert(Node root) {
        map.put(root.key, root);
        Node next = head.next;
        //Node prev = head.next.prev;
        head.next= root;
        root.prev = head;
        root.next = next;
        //prev = root;
        next.prev = root;
    }
    
    // Node nextNode = head.next; 
    //     head.next = node;
    //     node.prev = head;
    //     node.next = nextNode;
    //     nextNode.prev = node;
    
    void remove(Node noder) {
        Node root = map.remove(noder.key);
        //Node root = map.get(key);
        Node prev = root.prev;
        Node next = root.next;
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