import java.util.*;

class Solution {
    class Pair {
        String word;
        int level;
        Pair(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();
        if (!set.contains(endWord)) return result;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        Map<String, List<String>> adjList = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        
        for (String word : wordList) {
            adjList.put(word, new ArrayList<>());
        }
        
        adjList.put(beginWord, new ArrayList<>());
        distance.put(beginWord, 1); 
        set.add(beginWord);
        
        while (!q.isEmpty()) {
            Pair current = q.remove();
            String word = current.word;
            int level = current.level;
            for (int i = 0; i < word.length(); i++) {
                char[] wrd = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    wrd[i] = c;
                    String nextWord = String.valueOf(wrd);
                    if (set.contains(nextWord) && (!distance.containsKey(nextWord) || distance.get(nextWord) == level + 1)) {
                        if (!distance.containsKey(nextWord)) {
                            q.add(new Pair(nextWord, level + 1));
                            distance.put(nextWord, level + 1);
                        }
                        adjList.get(nextWord).add(word);
                    }
                }
            }
        }
        
        List<String> runningList = new ArrayList<>();
        backtrack(result, runningList, beginWord, endWord, adjList);
        return result;
    }

    private void backtrack(List<List<String>> result, List<String> runningList, String beginWord, String endWord, Map<String, List<String>> adjList) {
        if (endWord.equals(beginWord)) {
            runningList.add(0, beginWord);
            result.add(new ArrayList<>(runningList));
            runningList.remove(0);
            return;
        }
        runningList.add(0, endWord);
        for (String prevWord : adjList.get(endWord)) {
            backtrack(result, runningList, beginWord, prevWord, adjList);
        }
        runningList.remove(0);
    }

}
