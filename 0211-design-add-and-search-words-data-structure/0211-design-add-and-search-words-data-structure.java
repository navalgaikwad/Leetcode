class WordDictionary {
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
    Node root = new Node('\0');
    public WordDictionary() {
        
    }
    
    public void addWord(String word) {
        Node curr = root;
        for(char c: word.toCharArray()) {
            if(!curr.children.containsKey(c)) {
                curr.children.put(c, new Node(c));
            }
            curr = curr.children.get(c);
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
         Node curr = root;
        return searchInNode(word, curr);
    }
    //.ad
    private boolean searchInNode(String word, Node node) { 
        for(int i = 0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(!node.children.containsKey(c)) {//. nahi ahe
                if(c == '.') {
                    for(Node ch : node.children.values()) {
                        if(searchInNode(word.substring(i + 1), ch)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            node = node.children.get(c);
        }
        return node.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */