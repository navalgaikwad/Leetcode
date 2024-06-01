class WordDictionary {
    class Node {
        char c;
        Map<Character, Node> childrens;
        boolean isEnd;
        Node(char c) {
            this.c = c;
            this.childrens = new HashMap<>();
            this.isEnd= false;
        }
    }
    Node root;
    public WordDictionary() {
        root = new Node('\0');
    }
    
    public void addWord(String word) {
        Node current = root;
        for(char c : word.toCharArray()) {
            if(!current.childrens.containsKey(c)) {
                current.childrens.put(c, new Node(c));
            }
            current = current.childrens.get(c);
        }
        current.isEnd = true;
    }
    
    public boolean search(String word) {
        Node current = root;
       
        return searchWord(word, current);
    }
    
    boolean searchWord(String word, Node node) {
        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == '.') {
                 for(Node c : node.childrens.values()) {
                if(searchWord(word.substring(i + 1), c)) {
                    return true;
                }
            }
         }
            if(!node.childrens.containsKey(word.charAt(i))) {
                return false;
            }
          node = node.childrens.get(word.charAt(i));
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