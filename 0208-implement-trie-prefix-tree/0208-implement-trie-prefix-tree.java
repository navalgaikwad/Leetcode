class Node {
    Map<Character, Node> children;
    boolean isEnd;
    char c;
    Node(char c) {
        this.children = new HashMap<>();
        this.c = c;
        this.isEnd = false;
    }
}
class Trie {
    Node root;
    public Trie() {
        root = new Node('\0');
    }
    
    public void insert(String word) {
        Node curr = root;
        for(char c : word.toCharArray()) {
            Map<Character, Node> neighbour = curr.children;
            if(!neighbour.containsKey(c)) {
                neighbour.put(c, new Node(c));
            }
            curr = neighbour.get(c);
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        Node curr = root;
        for(char c : word.toCharArray()) {
            Map<Character, Node> neighbour = curr.children;
            if(!neighbour.containsKey(c)) {
                return false;
            }
            curr = neighbour.get(c);
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for(char c : prefix.toCharArray()) {
            Map<Character, Node> neighbour = curr.children;
            if(!neighbour.containsKey(c)) {
                return false;
            }
            curr = neighbour.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */