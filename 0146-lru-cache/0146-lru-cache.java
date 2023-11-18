class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    Map<Integer, Node> map = new HashMap<>();
    int capacity;
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    public LRUCache(int _capacity) {
        this.capacity = _capacity;
        head.next = tail;// very important 
        tail.prev = head;
    }
    
    public int get(int key) { 
        /*
        check if it present
        if present remove it
        than add it again
        other wise return -1
        */
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        /*
        1. check if value is there in map than remove
        2. check the size than also remove
        3. than insert
        */
       
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
        }
        if(map.size() == capacity){
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }
    
    void insert(Node node){
        map.put(node.key, node);
        Node nextHead = head.next;
        Node prevHead = head;
        
        head.next = node;
        node.prev = head;
        
        node.next = nextHead;
        nextHead.prev = node;
    }
    
    
     
    
    
    void remove(Node node){
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