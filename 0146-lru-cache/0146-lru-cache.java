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
    Node head = new Node(0, 0);//declare head
    Node tail = new Node(0, 0);//declare tail
    Map<Integer, Node> map = new HashMap<>();
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
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
        //1. check if key already exist same as get
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
        }
        if(map.size() == capacity) { //same size
            remove(tail.prev); 
        }
        add(new Node(key, value));
        
    }
    
//      private void insert(Node node) {
//         //add at first;
//         map.put(node.key, node); 
//         Node nextNode = head.next;
//         Node prevNode = head;
        
//         head.next = node;
//         node.prev = head;
//         node.next = nextNode;
//         nextNode.prev = node;
//     }
    
     private void add(Node node) {
        //Node temp = head;
        map.put(node.key, node); 
         Node prev = head;
         Node next = head.next;
         
         head.next = node;
         node.prev = head;
         node.next = next;
         
         next.prev = node;
         //prev.prev = node;
         
        
    }
    private void remove(Node node) {
        map.remove(node.key);
         //Node temp = head;
         Node prevNode = node.prev;
         Node nextNode = node.next;
         node.prev.next = nextNode;
         nextNode.prev = prevNode;
    }
    
    
}

//  private void insert(Node node) {
//         //add at first;
//         map.put(node.key, node); 
//         Node nextNode = head.next;
//         Node prevNode = head;
        
//         head.next = node;
//         node.prev = head;
//         node.next = nextNode;
//         nextNode.prev = node;
//     }
//     private void remove(Node node) {
//         map.remove(node.key);
//         Node prevNode = node.prev;
//         Node nextNode = node.next;
//         node.prev.next = nextNode;
//         nextNode.prev = prevNode;
//     }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */