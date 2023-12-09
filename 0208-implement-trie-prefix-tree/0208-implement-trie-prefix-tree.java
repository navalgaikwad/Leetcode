class Trie {

    class Node {
        char c;
        Map<Character, Node> children;
        boolean isEnd;
        Node(char c) {
            this.c = c;
            this.children = new HashMap<>();
            this.isEnd = false;
        }
    }
    Node root;
    public Trie() {
        this.root = new Node('\0');
    }
    
    public void insert(String word) {
        Node curr = root;
        for(char c : word.toCharArray()) {
            if(!curr.children.containsKey(c)) {
                curr.children.put(c, new Node(c));
            }
            curr = curr.children.get(c);
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        Node curr = root;
        for(char c : word.toCharArray()) {
            if(!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for(char c : prefix.toCharArray()) {
            if(!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
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