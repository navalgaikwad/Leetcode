class TrieNode{
    private TrieNode[] children;
    private boolean isEndOfWord; // which will have children and isEnd

    public TrieNode() {
        children = new TrieNode[26];  // 26 letters of the alphabet
        isEndOfWord = false;
    }

    public boolean containsKey(char ch) {
        return children[ch - 'a'] != null;//convert ch to integer and return the true o
    }

    public TrieNode get(char ch) {
        return children[ch - 'a'];//
    }

    public void put(char ch, TrieNode node) {
        children[ch - 'a'] = node;
    }

    public void setEnd() {
        isEndOfWord = true;
    }

    public boolean isEnd() {
        return isEndOfWord;
    }
}

class Trie {
    // new class 
    //TrieNode
    // which will have children and isEnd
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {//same as clone node
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) { // check if present if not present add currentChar to with next trieNode
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();// it will be at the last
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd(); //check node is not null and not end
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root; //searching start from root
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);// take one char
            if (node.containsKey(curLetter)) {// check if key is present
                node = node.get(curLetter); // assign next node value to node
            } else {
                return null; // if not matching return null
            }
        }
        return node;
    }
}

