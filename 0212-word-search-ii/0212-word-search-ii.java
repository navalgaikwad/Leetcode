import java.util.*;

class Solution {
    Set<String> result = new HashSet<>();
    TrieNode root = new TrieNode();

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null; // Store full word at the end node
    }

    public List<String> findWords(char[][] board, String[] words) {
        buildTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.children.containsKey(board[i][j])) {
                    helper(board, i, j, root);
                }
            }
        }
        return new ArrayList<>(result);
    }

    private void buildTrie(String[] words) {
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
            }
            node.word = word; // Store full word at the end node
        }
    }

    void helper(char[][] board, int i, int j, TrieNode node) {
        char c = board[i][j];
        if (!node.children.containsKey(c)) return;

        node = node.children.get(c);
        if (node.word != null) { // Found a valid word
            result.add(node.word);
            node.word = null; // Prevent duplicate insertions
        }

        board[i][j] = '#'; // Mark as visited

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : directions) {
            int newRow = i + dir[0], newCol = j + dir[1];
            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length) {
                helper(board, newRow, newCol, node);
            }
        }

        board[i][j] = c; // Backtrack to allow different paths
    }
}
