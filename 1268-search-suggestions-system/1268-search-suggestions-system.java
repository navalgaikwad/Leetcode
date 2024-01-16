import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Trie {

    // Node definition of a trie
    class Node {
        boolean isWord = false;
        Map<Character, Node> children = new HashMap<>();
    }

    Node root, curr;
    List<String> resultBuffer;

    // Runs a DFS on trie starting with given prefix and adds all the words in the resultBuffer, limiting result size to 3
    void dfsWithPrefix(Node curr, String word) {
        if (resultBuffer.size() == 3)
            return;
        if (curr.isWord)
            resultBuffer.add(word);

        // Run DFS on all possible paths.
        for (char c = 'a'; c <= 'z'; c++) {
            if (curr.children.containsKey(c))
                dfsWithPrefix(curr.children.get(c), word + c);
        }
    }

    Trie() {
        root = new Node();
    }

    // Inserts the string in trie.
    void insert(String s) {
        // Points curr to the root of trie.
        curr = root;
        for (char c : s.toCharArray()) {
            curr.children.putIfAbsent(c, new Node());
            curr = curr.children.get(c);
        }

        // Mark this node as a completed word.
        curr.isWord = true;
    }

    List<String> getWordsStartingWith(String prefix) {
        curr = root;
        resultBuffer = new ArrayList<>();
        // Move curr to the end of prefix in its trie representation.
        for (char c : prefix.toCharArray()) {
            if (!curr.children.containsKey(c))
                return resultBuffer;
            curr = curr.children.get(c);
        }
        dfsWithPrefix(curr, prefix);
        return resultBuffer;
    }
}

class Solution {
    List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        List<List<String>> result = new ArrayList<>();
        // Add all words to trie.
        for (String w : products)
            trie.insert(w);
        String prefix = new String();
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            result.add(trie.getWordsStartingWith(prefix));
        }
        return result;
    }
}
