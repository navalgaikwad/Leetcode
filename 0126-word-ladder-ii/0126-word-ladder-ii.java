class Solution {
    class Pair {
        String word;
        int count;

        Pair(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return new ArrayList<>();
        }
        Map<String, ArrayList<String>> adj = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        distance.put(beginWord, 1);
        Set<String> set = new HashSet<>(wordList);
        for (String word : wordList) {
            adj.put(word, new ArrayList<>());
        }
        adj.put(beginWord, new ArrayList<>());
        adj.put(endWord, new ArrayList<>());

        while (!q.isEmpty()) {
            Pair current = q.remove();
            String word = current.word;
            int level = current.count;
            for (int i = 0; i < word.length(); i++) {
                char wrd[] = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    wrd[i] = c;
                    String nextWord = String.valueOf(wrd);
                    if (set.contains(nextWord)) {
                        if (!distance.containsKey(nextWord)) {
                            q.add(new Pair(nextWord, level + 1));
                            distance.put(nextWord, level + 1);
                        }
                        if (distance.get(nextWord) == level + 1) {
                            adj.get(nextWord).add(word);
                        }

                    }
                }
            }
        }
        List<List<String>> result = new ArrayList<>();
        backTracking(result, beginWord, endWord, new ArrayList<>(), adj);
        return result;
    }

    void backTracking(List<List<String>> result, String begin, String end, ArrayList<String> runningList,
            Map<String, ArrayList<String>> adj) {
        if (end.equals(begin)) {
            runningList.add(0, begin);
            result.add(new ArrayList<>(runningList));
            runningList.remove(0);
            return;
        }
        runningList.add(0, end);
        for (String previous : adj.get(end)) {
            backTracking(result, begin, previous, runningList, adj);
        }

        runningList.remove(0);
    }
}