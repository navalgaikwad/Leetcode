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
    Node root;
    public WordDictionary() {
        root = new Node('\0');
    }
    
    public void addWord(String word) {
        Node current = root;
        for(char c : word.toCharArray()) {
            if(!current.children.containsKey(c)) {
                current.children.put(c, new Node(c));
            }
            current = current.children.get(c);
        }
        current.isEnd = true;
    }
    //.ad
    public boolean search(String word) {
        Node current = root;
       return searchInNode(word, current);
    }
    
     private boolean searchInNode(String word, Node node) { 
      Node current = node;
        for(int i=0; i<word.length(); i++) {
            if(word.charAt(i) == '.') {
                for(Node c : current.children.values()) {//vvimp loop from map
                    if(searchInNode(word.substring(i + 1), c)) {
                    return true;
                }
              }
                
            }
            if(!current.children.containsKey(word.charAt(i))) {
                return false;
            }
            current = current.children.get(word.charAt(i));
        }
        return current.isEnd;
     }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */