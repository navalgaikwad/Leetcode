class Node {
    char c;
    boolean isEnd;
    HashMap<Character, Node> children;
    Node(char c) {
        this.children = new HashMap<>();
        this.isEnd = false;
        this.c = c;
    }
}
class Trie {
    Node root;
    public Trie() {
        root = new Node('\0');
    }
    
    public void insert(String word) {
        Node curr = root;
        for(char wrd: word.toCharArray()) {
            if(!curr.children.containsKey(wrd)) {
                 curr.children.put(wrd, new Node(wrd));
            }
           curr = curr.children.get(wrd);
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
         Node curr = root;
        for(char wrd: word.toCharArray()) {
            if(!curr.children.containsKey(wrd)) {
                 return false;
            }
           curr = curr.children.get(wrd);
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for(char wrd: prefix.toCharArray()) {
            if(!curr.children.containsKey(wrd)) {
                 return false;
            }
           curr = curr.children.get(wrd);
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